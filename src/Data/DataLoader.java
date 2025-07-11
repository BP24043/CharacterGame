package Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class DataLoader {
    /*
        基本+だくてん+はんだくてん+小さい やゆよ+小さい つ
        46+20+5+3+1
    */
    public static final int HIRAGANA_COUNT = 75;
    public static final String CHARACTER_DATA_FILE_NAME = "src/Data/Character.txt";

    private String nameData[] = new String[HIRAGANA_COUNT];
    private int healthData[] = new int[HIRAGANA_COUNT];
    private int attackData[] = new int[HIRAGANA_COUNT];
    private int speedData[] = new int[HIRAGANA_COUNT];

    public DataLoader(){

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
                } catch(NumberFormatException e){
                    System.err.println("数値変換エラーが発生したらしいよ");
                }
                index++;
            }
        } catch(IOException e){
            System.err.println("ファイル読み込みにエラーが起こったらしい...");
            e.printStackTrace();
        }


        System.out.println("読み込んだデータ\n");
        for(int i = 0; i < HIRAGANA_COUNT; i++){
            System.out.println("name = " + nameData[i]);
            System.out.println("healthData = " + healthData[i]);
            System.out.println("attackData = " + attackData[i]);
            System.out.println("speedData = " + speedData[i]);
            System.out.println("\n");
        }
    }
}
