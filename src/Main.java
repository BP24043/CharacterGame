import java.util.Scanner;

/*
1.コメント、空白行などを除く行数が100行以上
2.3クラス以上で構成
3.継承を使用
4.インタフェースの宣言と実装
5.例外の宣言と使用
6.パッケージの宣言と使用
7.ファイル、ネットワーク入力、もしくは出力
8.Streamを使用

 */

public class Main {

    public static String userName;

    public static void main(String[] args) {

        String userName;

        Scanner scan = new Scanner(System.in);
        Input input = new Input();
        Output output = new Output();
        Story story = new Story();
        Rest rest = new Rest();
        Battle battle = new Battle();

        story.startStory(0);

        story.startStory(1);

        //初回の休憩ターンは強化できない
        rest.noRest();



        battle.start();





        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            output.printSystem("スリープが中断された...だと？！");
            Thread.currentThread().interrupt();
        }

        output.printSystem("おわり");



    }
}