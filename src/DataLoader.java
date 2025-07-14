import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class DataLoader {

    private static final DataLoader INSTANCE = new DataLoader();

    /*
        基本+だくてん+はんだくてん+小さい やゆよ+小さい つ
        46+20+5+3+1
    */
    private static final int HIRAGANA_COUNT = 75;
    private static final int MAGIC_COUNT = 15;
    private static final int ENEMY_COUNT = 3;

    private static final String CHARACTER_DATA_FILE_NAME = "src/Data/Character.txt";
    private static final String MAGIC_DATA_FILE_NAME = "src/Data/Magic.txt";
    private static final String ENEMY_DATA_FILE_NAME = "src/Data/enemy.txt";

    //キャラクターのデータ
    private final String[] nameData = new String[HIRAGANA_COUNT];
    private final int[] healthData = new int[HIRAGANA_COUNT];
    private final int[] attackData = new int[HIRAGANA_COUNT];
    private final int[] speedData = new int[HIRAGANA_COUNT];
    private final int[] magicData = new int[HIRAGANA_COUNT];
    private final int[] magicCostData = new int[HIRAGANA_COUNT];

    //魔法のデータ
    private final String[] magicNameData = new String[MAGIC_COUNT];
    private final String[] magicBeforeMessageData = new String[MAGIC_COUNT];
    private final String[] magicMessageData = new String[MAGIC_COUNT];
    private final int[] magicPowerData = new int[MAGIC_COUNT];
    private final String[] magicAfterMessageData = new String[MAGIC_COUNT];

    //敵のデータ
    private final String[] enemyNameData = new String[ENEMY_COUNT];
    private final int[] enemyHealthData = new int[ENEMY_COUNT];
    private final int[] enemyAttackData = new int[ENEMY_COUNT];


    private String userName;

    private DataLoader(){

        BufferedReader reader;
        int index = 0;

        try{
            //キャラクターのデータ読み込み
            reader = new BufferedReader(new FileReader(CHARACTER_DATA_FILE_NAME));
            String line;

            reader.readLine();
            index = 0;

            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                try{
                    nameData[index] = data[1].trim();
                    healthData[index] = Integer.parseInt(data[2].trim());
                    attackData[index] = Integer.parseInt(data[3].trim());
                    speedData[index] = Integer.parseInt(data[4].trim());
                    magicData[index] = Integer.parseInt(data[5].trim());
                    magicCostData[index] = Integer.parseInt(data[6].trim());
                } catch(NumberFormatException e){
                    System.err.println("数値変換エラーが発生したらしいよ");
                }
                index++;
            }

            //魔法のデータ読み込み
            reader = new BufferedReader(new FileReader(MAGIC_DATA_FILE_NAME));
            reader.readLine();
            index = 0;

            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                try{
                    magicNameData[index] = data[1].trim();
                    magicBeforeMessageData[index] = data[2].trim();
                    magicMessageData[index] = data[3].trim();
                    magicPowerData[index] = Integer.parseInt(data[4].trim());
                    magicAfterMessageData[index] = data[5].trim();

                } catch(NumberFormatException e){
                    System.err.println("数値変換エラーが発生したらしいよ");
                }
                index++;
            }

            //敵データ読み込み
            reader = new BufferedReader(new FileReader(ENEMY_DATA_FILE_NAME));
            reader.readLine();
            index = 0;

            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                try{
                    enemyNameData[index] = data[1].trim();
                    enemyHealthData[index] = Integer.parseInt(data[2].trim());
                    enemyAttackData[index] = Integer.parseInt(data[3].trim());

                } catch(NumberFormatException e){
                    System.err.println("数値変換エラーが発生したらしいよ");
                }
                index++;
            }

        } catch(IOException e){
            System.err.println("ファイル読み込みにエラーが起こったらしい...");
            e.printStackTrace();
        }
    }

    public static DataLoader getInstance(){
        return INSTANCE;
    }

    public String getNameData(int id){
        return nameData[id];
    }

    public int getHealthData(int id){
        return healthData[id];
    }

    public int getAttackData(int id){
        return attackData[id];
    }

    public int getSpeedData(int id){
        return speedData[id];
    }

    public int getMagicData(int id){
        return magicData[id];
    }

    public int getMagicCostData(int id){
        return magicCostData[id];
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public int getHIRAGANA_COUNT(){
        return HIRAGANA_COUNT;
    }

    public String getMagicNameData(int id){
        return magicNameData[id];
    }

    public String getEnemyNameData(int id){
        return enemyNameData[id];
    }

    public int getEnemyHealthData(int id){
        return enemyHealthData[id];
    }

    public int getEnemyAttackData(int id){
        return enemyAttackData[id];
    }

    public String getMagicBeforeMessageData(int id){
        return magicBeforeMessageData[id];
    }

    public int getMagicPowerData(int id){
        return magicPowerData[id];
    }

    public String getMagicAfterMessageData(int id){
        return magicAfterMessageData[id];
    }

    public String getMagicMessageData(int id){
        return magicMessageData[id];
    }

    public int getENEMY_COUNT(){
        return ENEMY_COUNT;
    }
}
