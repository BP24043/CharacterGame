import java.io.IOException;
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

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Input input = new Input();
        Output output = new Output();
        String inputString = input.getInput();

        output.print("入力された文字は「"+inputString+"」です");

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            output.print("スリープが中断された...だと？！");
            Thread.currentThread().interrupt();
        }

        output.print("おわり");

    }
}