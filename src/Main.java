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
    public static int level = 1;
    public static Battle battle = new Battle();

    public static void main(String[] args) {

        String userName;

        Scanner scan = new Scanner(System.in);
        Input input = new Input();
        Output output = new Output();
        Story story = new Story();
        Rest rest = new Rest();

        story.startStory(0);

        story.startStory(1);

        story.startStory(2);

        //初回の休憩ターンは強化できない
        rest.noRest();

        battle.start(CharacterGenerate.getInstance().getCharacters());

    }

    public static void Rest(){

        Rest rest = new Rest();

        if(rest.Rest()){ //強化をした場合trueになる
            rest.noRest();
        }

        battle.start(CharacterGenerate.getInstance().getCharacters());
    }

    public static void GameOver(){

        Story story = new Story();
        story.startStory(444);
    }
}