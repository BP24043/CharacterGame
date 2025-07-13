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
    private static final String CHARACTER_DATA_FILE_NAME = "src/Character.txt";

    private final String[] nameData = new String[HIRAGANA_COUNT];
    private final int[] healthData = new int[HIRAGANA_COUNT];
    private final int[] attackData = new int[HIRAGANA_COUNT];
    private final int[] speedData = new int[HIRAGANA_COUNT];
    private final int[] magicData = new int[HIRAGANA_COUNT];
    private final int[] magicCostData = new int[HIRAGANA_COUNT];

    private String userName;

    private DataLoader(){

        BufferedReader reader;
        int index = 0;

        try{
            reader = new BufferedReader(new FileReader(CHARACTER_DATA_FILE_NAME));
            String line;

            reader.readLine();

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

}
