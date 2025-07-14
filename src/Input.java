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
        System.out.println("～現在地点：地下" + Main.battle.level + "階～");
        System.out.println("文字たちを見る場合...「もじ」と入力");
        System.out.println("先に進む場合...「すすむ」と入力");
        System.out.print("　　　どうする？：");
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

    public int getAction_2() {
        System.out.println("～現在地点：地下" + Main.battle.level + "階～");
        System.out.println("文字たちを見る場合...「もじ」と入力");
        System.out.println("文字を強化する場合...「きょうか」と入力");
        System.out.println("先に進む場合...「すすむ」と入力");
        System.out.print("　　　どうする？：");
        Scanner scan = new Scanner(System.in);

        String input = scan.next();

        for(int i = 0; i < NEWLINE_COUNT; i++){
            System.out.println("\n");
        }

        if(input.equals("もじ")){
            for(int i = 0; i < NEWLINE_COUNT; i++){
                System.out.println("\n");
            }
            return 1;
        }
        else if(input.equals("すすむ")){
            for(int i = 0; i < NEWLINE_COUNT; i++){
                System.out.println("\n");
            }
            return 2;
        }
        else if(input.equals("きょうか")){
            for(int i = 0; i < NEWLINE_COUNT; i++){
                System.out.println("\n");
            }
            return 3;
        }
        return 0;
    }

    public char getInput_1moji(){
        System.out.print("何文字目の文字を強化するか全角数字で入力（やめる場合は「やめる」と入力）：");
        Scanner scan = new Scanner(System.in);
        String string = scan.next();

        if(string.equals("やめる")){
            for(int i = 0; i < NEWLINE_COUNT; i++){
                System.out.println("\n");
            }
            return 'q';
        }

        return string.charAt(0);
    }

    public char getInput_1moji_2(){
        System.out.println("た：体力上昇　こ：攻撃力上昇　す：素早さ上昇　い：魔法の威力上昇　ま：魔法のコスト低下");
        System.out.print("強化したい内容を入力（やめる場合は「やめる」と入力）：");

        Scanner scan = new Scanner(System.in);
        String string = scan.next();

        if(string.equals("やめる")){
            for(int i = 0; i < NEWLINE_COUNT; i++){
                System.out.println("\n");
            }
            return 'q';
        }

        for(int i = 0; i < NEWLINE_COUNT; i++){
            System.out.println("\n");
        }
        return string.charAt(0);
    }
}

