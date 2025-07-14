import javax.xml.crypto.Data;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {

    Output output = new Output();
    Input input = new Input();

    public AtomicInteger enemyHealth = new AtomicInteger(1000);
    public AtomicInteger characterHealth = new AtomicInteger();
    public int level = 1;

    private ScheduledExecutorService scheduler;
    private final List<ScheduledFuture<?>> scheduledTasks = new ArrayList<>();

    private ScheduledFuture<?> terminationTaskFuture;

    private int whatEnemy;

    public void start(Character[] characters){
        if(characters == null || characters.length == 0){
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

        enemyHealth = new AtomicInteger((int) (100 * this.level * 0.4f));
        scheduler = Executors.newScheduledThreadPool(characters.length);

        int healthAmount = 0;
        for(Character character: characters){
            if(character != null)
                healthAmount += character.getHealth();
        }
        characterHealth = new AtomicInteger(healthAmount);

        terminationTaskFuture = scheduler.schedule(() -> {
            output.printSystem("");
            output.printSystem("敵が疲れ果てて倒れてしまった！\n");
            endBattle();
        },15,TimeUnit.SECONDS);

        long firstDeleyMs = 0;
        final long STAGGER_DELAY_MS = 500;



        int enemyAttackDamage = (int) (this.level * DataLoader.getInstance().getEnemyAttackData(this.whatEnemy));

        Runnable enemyAttackTask = () -> {
            // 戦闘が終了しているか、キャラクターの体力が0以下なら攻撃を停止
            if (characterHealth.get() <= 0 || scheduler.isShutdown()) {
                return;
            }

            // characterHealthを減少させる
            int remainingCharacterHealth = characterHealth.addAndGet(-enemyAttackDamage);
            output.printSystem("【敵の攻撃】キャラクターに" + enemyAttackDamage + "ダメージ！" + " 残り文字たちの体力：" + remainingCharacterHealth);

            // キャラクターの体力が0以下になった場合の処理
            if (remainingCharacterHealth <= 0) {
                // 戦闘終了
                defeatBattle();
            }
        };

        ScheduledFuture<?> enemyAttackFuture = scheduler.scheduleAtFixedRate(enemyAttackTask, 1, 1, TimeUnit.SECONDS);
        scheduledTasks.add(enemyAttackFuture);



        for(Character character: characters){
            if (character == null) {
                continue;
            }

            int attack = character.getAttack();
            long interval = Math.max(1, character.getSpeed()) * 100L;

            Runnable attackTask = () -> {
                if (enemyHealth.get() <= 0) {
                    return;
                }

                //魔法が発動するか
                if(character.getNowMagicCost() == character.getMagicCost()){
                    output.printSystem("【" + character.getName() + "が魔法を発動！】「" + DataLoader.getInstance().getMagicBeforeMessageData(character.getMagic()) + DataLoader.getInstance().getMagicMessageData(character.getMagic()) + character.getMagicPower() + DataLoader.getInstance().getMagicAfterMessageData(character.getMagic()) + "」");
                    character.setNowMagicCost(0);
                }
                else{ //普通に攻撃するか
                    int remainingHealth = enemyHealth.addAndGet(-attack);
                    output.printSystem("【" + character.getName() + "の攻撃】" + attack + "ダメージを与えた！"+ " 残り敵体力：" + enemyHealth + " 残り戦闘時間：" + getRemainingTimeSeconds() + "秒");
                    character.setNowMagicCost(1);
                    if(remainingHealth <= 0){
                        endBattle();
                    }
                }


            };


            for(Character character2: characters) {
                if (character2 == null) {
                    continue;
                }
            }

            ScheduledFuture<?> task = scheduler.scheduleAtFixedRate(attackTask, firstDeleyMs, interval, TimeUnit.MILLISECONDS);
            scheduledTasks.add(task);

            firstDeleyMs += STAGGER_DELAY_MS;

        }
    }

    private long getRemainingTimeSeconds(){
        if(terminationTaskFuture != null && !terminationTaskFuture.isDone()){
            return terminationTaskFuture.getDelay(TimeUnit.SECONDS);
        }
        return 0;
    }

    private void endBattle(){
        if(scheduler == null || scheduler.isShutdown()){
            return;
        }

        for(ScheduledFuture<?> task : scheduledTasks){
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


    private void defeatBattle(){
        if(scheduler == null || scheduler.isShutdown()){
            return;
        }

        for(ScheduledFuture<?> task : scheduledTasks){
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


    public int getLevel(){
        return this.level;
    }

}
