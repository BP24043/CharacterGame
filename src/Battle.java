import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;


public class Battle {

    Output output = new Output();
    Input input = new Input();

    public AtomicInteger enemyHealth = new AtomicInteger(1000);
    public int enemyAttackPlus = 0;
    public AtomicInteger characterHealth = new AtomicInteger();
    public int characterHealthPlus = 0;
    public int level = 1;

    private ScheduledExecutorService scheduler;
    private final List<ScheduledFuture<?>> scheduledTasks = new ArrayList<>();

    private ScheduledFuture<?> terminationTaskFuture;

    private int whatEnemy;

    private interface Magic {
        void useMagic(Character[] characters, Character user, Battle battle);
    }

    private final Map<Integer, Magic> magicMap = new ConcurrentHashMap<>();

    public Battle() {
        magicMap.put(0, (characters, user, battle) -> {
            // Magic_0の具体的な効果をここに実装
        });
        magicMap.put(1, (characters, user, battle) -> {
            // Magic_1の具体的な効果をここに実装
        });
        magicMap.put(2, (characters, user, battle) -> {
            battle.enemyAttackPlus += user.getMagicPower();
        });
        magicMap.put(3, (characters, user, battle) -> {
            // Magic_3の具体的な効果をここに実装
        });
        magicMap.put(4, (characters, user, battle) -> {
            for (Character character : characters) {
                if (character != null) {
                    character.setHealthByYourSelf(character.getHealth() + user.getMagicPower());
                }
            }
            battle.updateCharacterHealth(characters);
        });
        magicMap.put(5, (characters, user, battle) -> {
            user.setSpeedByYourSelf(user.getSpeed() + user.getMagicPower());
        });
        magicMap.put(6, (characters, user, battle) -> {
            for (Character character : characters) {
                if (character != null) {
                    character.setHealthByYourSelf(character.getHealth() + user.getMagicPower());
                }
            }
            user.setSpeedByYourSelf(user.getSpeed() + user.getMagicPower());
            battle.updateCharacterHealth(characters);
        });
        magicMap.put(7, (characters, user, battle) -> {
            user.setSpeedByYourSelf(user.getSpeed() + user.getMagicPower());
        });
        magicMap.put(8, (characters, user, battle) -> {
            for (Character character : characters) {
                if (character != null) {
                    character.setHealthByYourSelf(character.getHealth() + user.getMagicPower());
                }
            }
            battle.updateCharacterHealth(characters);
        });
        magicMap.put(9, (characters, user, battle) -> {
            for (Character character : characters) {
                if (character != null) {
                    character.setHealthByYourSelf(character.getHealth() + user.getMagicPower());
                }
            }
            user.setSpeedByYourSelf(user.getSpeed() + user.getMagicPower());
            battle.updateCharacterHealth(characters);
        });
        magicMap.put(10, (characters, user, battle) -> {
            for (Character character : characters) {
                if (character != null) {
                    character.setHealthByYourSelf(character.getHealth() + user.getMagicPower());
                }
            }
            user.setSpeedByYourSelf(user.getSpeed() + user.getMagicPower());
            battle.updateCharacterHealth(characters);
        });
    }

    public void start(Character[] characters) {
        if (characters == null || characters.length == 0) {
            System.err.println("なんか渡されたcharactersがエラーだ！");
            return;
        }

        Random random = new Random();
        this.whatEnemy = random.nextInt(DataLoader.getInstance().getENEMY_COUNT());

        output.printSystem("" + DataLoader.getInstance().getEnemyNameData(whatEnemy) + " が現れた！");
        output.printSystem("戦闘開始！\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("スレッドが中断されました。");
        }

        enemyHealth = new AtomicInteger((int) (DataLoader.getInstance().getEnemyHealthData(whatEnemy) + DataLoader.getInstance().getEnemyHealthData(whatEnemy) * this.level * 0.4f));
        scheduler = Executors.newScheduledThreadPool(characters.length);

        characterHealth = new AtomicInteger(calcTotalCharacterHealth(characters));

        terminationTaskFuture = scheduler.schedule(() -> {
            output.printSystem("");
            output.printSystem("敵が疲れ果てて倒れてしまった！\n");
            endBattle();
        }, 15, TimeUnit.SECONDS);

        long firstDelayMs = 0;
        final long STAGGER_DELAY_MS = 500;

        Runnable enemyAttackTask = () -> {
            if (characterHealth.get() <= 0 || scheduler.isShutdown()) {
                return;
            }

            int damage = this.level * (DataLoader.getInstance().getEnemyAttackData(this.whatEnemy) + enemyAttackPlus);
            int remainingCharacterHealth = characterHealth.addAndGet(-damage);
            output.printSystem("【敵の攻撃】キャラクターに" + damage + "ダメージ！" + " 残り文字たちの体力：" + (remainingCharacterHealth + characterHealthPlus));

            if (remainingCharacterHealth + characterHealthPlus <= 0) {
                defeatBattle();
            }
        };

        ScheduledFuture<?> enemyAttackFuture = scheduler.scheduleAtFixedRate(enemyAttackTask, 1, 1, TimeUnit.SECONDS);
        scheduledTasks.add(enemyAttackFuture);

        for (Character character : characters) {
            if (character == null) {
                continue;
            }

            Runnable attackTask = () -> {
                if (enemyHealth.get() <= 0) {
                    return;
                }

                if (character.getNowMagicCost() >= character.getMagicCost()) {
                    output.printSystem("【" + character.getName() + "が魔法を発動！】「" + DataLoader.getInstance().getMagicBeforeMessageData(character.getMagic()) + DataLoader.getInstance().getMagicMessageData(character.getMagic()) + character.getMagicPower() + DataLoader.getInstance().getMagicAfterMessageData(character.getMagic()) + "」");
                    character.setNowMagicCost(0);

                    Magic magic = magicMap.get(character.getMagic());
                    if (magic != null) {
                        magic.useMagic(characters, character, this);
                    } else {
                        System.err.println("存在しない魔法を打とうとしています！マジックID: " + character.getMagic());
                    }
                } else {
                    int remainingHealth = enemyHealth.addAndGet(-character.getAttack());
                    output.printSystem("【" + character.getName() + "の攻撃】" + character.getAttack() + "ダメージを与えた！" + " 残り敵体力：" + enemyHealth + " 残り戦闘時間：" + getRemainingTimeSeconds() + "秒");
                    character.setNowMagicCost(1);
                    if (remainingHealth <= 0) {
                        endBattle();
                    }
                }
            };

            ScheduledFuture<?> task = scheduler.scheduleAtFixedRate(attackTask, firstDelayMs, calculateInterval(character.getSpeed()), TimeUnit.MILLISECONDS);
            scheduledTasks.add(task);

            firstDelayMs += STAGGER_DELAY_MS;
        }
    }

    public void addEnemyAttackPlus(int amount) {
        this.enemyAttackPlus += amount;
    }

    public void updateCharacterHealth(Character[] characters) {
        this.characterHealth.set(calcTotalCharacterHealth(characters));
    }

    public void setCharacterHealthPlus(int amount) {
        this.characterHealthPlus = amount;
    }

    private int calcTotalCharacterHealth(Character[] characters) {
        int healthAmount = 0;
        for (Character character : characters) {
            if (character != null)
                healthAmount += character.getHealth();
        }
        return healthAmount;
    }

    private long calculateInterval(int speed) {
        return Math.max(1, speed) * 100L;
    }

    private long getRemainingTimeSeconds() {
        if (terminationTaskFuture != null && !terminationTaskFuture.isDone()) {
            return terminationTaskFuture.getDelay(TimeUnit.SECONDS);
        }
        return 0;
    }

    private void endBattle() {
        if (scheduler == null || scheduler.isShutdown()) {
            return;
        }

        for (ScheduledFuture<?> task : scheduledTasks) {
            task.cancel(false);
        }

        if (terminationTaskFuture != null) {
            terminationTaskFuture.cancel(true);
        }

        scheduler.shutdown();
        output.printSystem("戦闘終了！");
        output.printSystem("" + DataLoader.getInstance().getEnemyNameData(this.whatEnemy) + "に勝利した！\n");
        this.level++;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("スレッドが中断されました。");
        }

        Main.Rest();
    }

    private void defeatBattle() {
        if (scheduler == null || scheduler.isShutdown()) {
            return;
        }

        for (ScheduledFuture<?> task : scheduledTasks) {
            task.cancel(false);
        }

        if (terminationTaskFuture != null) {
            terminationTaskFuture.cancel(true);
        }

        scheduler.shutdown();
        output.printSystem("敗北...");
        output.printSystem("" + DataLoader.getInstance().getEnemyNameData(this.whatEnemy) + "に倒されてしまった...\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("スレッドが中断されました。");
        }

        Main.GameOver();
    }

    public int getLevel() {
        return this.level;
    }
}