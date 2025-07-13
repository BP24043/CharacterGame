import java.io.IOException;
import java.util.Scanner;

public class Input {

    public static int NEWLINE_COUNT = 10;

    public String getInput(){
        System.out.print("入力：");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public boolean getChoice(){
        System.out.print("\n　　　はい か いいえ を入力：");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        for(int i = 0; i < NEWLINE_COUNT; i++){
            System.out.println("\n");
        }

        if(input.equals("はい")){
            return true;
        }
        return false;
    }

    public boolean getEnter() {
        System.out.print("\n　　　Enterで次に進む：");
        Scanner scan = new Scanner(System.in);

        scan.nextLine();

        for(int i = 0; i < NEWLINE_COUNT; i++){
            System.out.println("\n");
        }

        return true;
    }

    public int getAction_1() {
        System.out.print("文字たちを見る場合...「もじ」と入力");
        System.out.print("先に進む場合...「すすむ」と入力");
        System.out.print("\n　　　どうする？：");
        Scanner scan = new Scanner(System.in);

        String input = scan.next();

        for(int i = 0; i < NEWLINE_COUNT; i++){
            System.out.println("\n");
        }

        if(input.equals("もじ")){
            return 1;
        }
        else if(input.equals("すすむ")){
            return 2;
        }
        return 0;
    }
}

