import java.util.Scanner;


public class Story {

    Scanner scan = new Scanner(System.in);
    Input input = new Input();
    Output output = new Output();

    // 共通のリセットコード
    public static final String ANSI_RESET = "\u001B[0m";

    // スタイルのコード
    public static final String ANSI_BOLD = "\u001B[1m";

    // 文字色のコード
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public void startStory(int type){
        if(type == 0){
            while(true){
                output.printSystem("あなたの名前を入力してください");
                output.printSystem("（ひらがなで六文字まで）");
                String tmpName = input.getInput();
                if(CharacterGenerate.getInstance().ResetCharacter(tmpName)){
                    DataLoader.getInstance().setUserName(tmpName);
                    output.printSystem("「"+DataLoader.getInstance().getUserName()+"」でよろしいですか？");
                    if(input.getChoice()){
                        break;
                    }
                }
            }
        }
        else if(type == 1){

            output.printSystem("～オープニング～");
            output.printSystem("あなたは駆け出しの冒険者です。");
            output.printSystem("適当に入った近場のダンジョンで、");
            output.printSystem("なんと偶然にも杖を発見しました！");

            input.getEnter();

            output.printSystem("手に取って確認すると、その杖はずっしりとしていて");
            output.printSystem("宝石で煌びやかに装飾が施されているのが分かりました。");
            output.printCharacter("なんかすごそう！");
            output.printCharacter("やった！");

            input.getEnter();

            output.printSystem("あなたは一緒に置いてあったREAD MEを読むことにしました。");

            input.getEnter();

            output.printSystem("「名操の杖」");
            output.printSystem("開発年：20XX年　共同開発者：縺溘％縺");
            output.printSystem("名前を操る、非戦闘員用の魔法の杖。");
            output.printSystem(ANSI_BOLD + "詠唱者の名前の１文字１文字が具現化し、戦ってくれます。" + ANSI_RESET);
            output.printSystem("かなり強力ですが、代わりに" + ANSI_BOLD + "使用者は名前を失います。" + ANSI_RESET);

            input.getEnter();

            output.printSystem("使い方：手に握るだけ");

            input.getEnter();

            output.printCharacter("え？！");

            input.getEnter();

            output.printSystem("        `      `  `       `                              `  `  `  `  `  `  `  `  `      `  `  `  `  `\n" +
                    "     `     `                  `  `           `     `  `                                                `     `\n" +
                    "                     `           .    `   `                                          `                                                           `\n" +
                    "                        `  `   .uMMNNNg_         `             -MMMMN}    ....................      `     `                                      .MMMMMb             ,MMMMM}\n" +
                    "    `         `  `            .MMMMMMMl............       `    (MMMMM}    .MMMMMMMMMMMMMMMMMM}  `              `                                 .MMMMM@             ,MMMMM}\n" +
                    "         `          `      .(MMMMMMMMMMMMMMMMMMMMMNe.        ` (MMMMM}    .MMMMMMMMMMMMMMMMMM}         `        ..JgNMMMMMMMNNg..                .MMMMM@             ,MMMMM}\n" +
                    "                       ` .&MMMMMMMMMMMMMMMMMMMMMMMMMNp      `  (MMMMM}    .MMMMMN......jMMMMM}     `       ` .gMMMMMMMMMMMMMMMMMMNe.       `......MMMMMb.... .........MMMMMl......\n" +
                    "           `    `     .(MMMMMMMM#\"\"\"\"\"\"\"\"\"\"TMMMMMMMMY    ` .NNNMMMMMMNN{  .MMMMMMMMMMMMMMMMMM}            .(MMMMMMMMMMMMMMMMMMMMMMMMm.      JMMMMMMMMMMMMMMM~dMMMMMMMMMMMMMMMMMMMN:\n" +
                    "    `   `          .gMMMMMMMMMMMm,       .(MMMMMMMD`       .MMMMMMMMMMM{  .HHHHHHHHHHHHHHHHHB:        `  .MMMMMMM9=(MMMMM}    ?TMMMMMN/`    JMMMMMMMMMMMMMMM~dMMMMMMMMMMMMMMMMMMMN:\n" +
                    "                   (MMMMMMMMMMMMMMN,   .+MMMMMMM@!         .MMMMMMMMMMM:.ggggggggggp(gggggggggg|  `     +MMMMM#=   ,MMMMM{      .MMMMMNo    (\"\"\"\"TMMMMMM#\"\"\"`7\"\"\"\"\"\"\"TMMMMM#\"\"\"\"\"\"`\n" +
                    "              `      TMMMB^ 7MMMMMMMN&NMMMMMMM@!               (MMMMM}  (MMMMMMMMMM#JMMMMMMMMMM]       dMMMMMD     (MMMMN!        MMMMMN.        (MMMMMMMe     ..(p  ,MMMMM%\n" +
                    "     `    `      `    ?!      TMMMMMMMMMMMMMY`                 (MMMMMae (MMMMY7MMMM#JMMMMY7MMMM]      (MMMMMF      JMMMM#         ,MMMMMr       .MMMMMMMMMm. .MMMMN, ,MMMMM\\\n" +
                    "                              .(MMMMMMMMMB=              `   ..+MMMMMMN.(MMMMNgMMMM#JMMMMNgMMMM]     .MMMMM#`      MMMMMD          MMMMMb      .MMMMMMMMMMMN, dMMMMb.JMMMMM:\n" +
                    "                    `     ..gMMMMMMMMMMNNgggggggggggg[     (MMMMMMMMMMM](MMMMMMMMMMNdMMMMMMMMMM]     .MMMMMF      .MMMMM\\         .MMMMMb     .MMMMMMMMMMMMMMr.MMMMMpdMMMM#`\n" +
                    "    `    `  `  `   ...JgMMMMMMMMMMMMMMMMMMMMMMMMMMMMMP      MMMMMMMMMY`  ????????MMMMMN7???????!     JMMMMM]     .dMMMM#`         (MMMMMt    .MMMMMMMMM#TMMM@` (MMMMMMMMMMF\n" +
                    "                  (MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMP  `   dH9UMMMMM{dNNNNNNNNNNMMMMMMNNNNNNNNNNN   (MMMMM#    .dMMMMM\\         .MMMMM#!   .MMMMMMMMMM@ (M@`   ?MMMMMMMM#!\n" +
                    "                   .HMMMMMMMMMMMMN`            .MMMMMP         (MMMMM{MMMMMMMMMMMMMMMMMMMMMMMMMMMN`   MMMMMMp. .MMMMMMF         .MMMMMM%    (MMMMMMMMMM@         ?MMMMMMM%\n" +
                    "                     TB\"=`  dMMMMN             .MMMMMP         (MMMMM{T\"\"\"\"\"WMMMMMMMMMMMMMMY\"\"\"\"\"9`   (MMMMMMMMMMMMMMD       ..MMMMMMM%      ?MMM<MMMMM@        .(MMMMMMMNe.\n" +
                    "    `   `  `   `            dMMMMN             .MMMMMP         (MMMMM}    .(MMMMMMMMMMMMMMMNa,         ?MMMMMMMMMMMM=     .(gMMMMMMMB!        ?M'.MMMMM@      .(MMMMMMMMMMMMN,.\n" +
                    "                            dMMMMMNNNNNNNNNNNNNMMMMMMP      ...(MMMMM}..gMMMMMMMMMMMMMMMMMMMMMMNg..     .TMMMMMMMMD`    ?MMMMMMMMM#=             .MMMMM@  ..JNMMMMMMMYTMMMMMMMMNg..\n" +
                    "                            dMMMMMMMMMMMMMMMMMMMMMMMMP   `  (MMMMMMMM{?MMMMMMMMY`dMMMMN~7MMMMMMMM@         ?T\"B\"=        ?MMMMMMY!               .MMMMM@`?MMMMMMMMMD!   7MMMMMMMMMD\n" +
                    "     `         `  `         dMMMMMMMMMMMMMMMMMMMMMMMMP       MMMMMMM#! ?MMMM#=   dMMMMN~  _TMMMMF                         (MB\"`                  .MMMMM@  (MMMMM#\"`       _TMMMMMF\n" +
                    "          `          `      VHHHH8             .\"\"\"\"\"3       (HHHHB\"`   (\"=`    `dMMMMB`      ?\"                                                 .HHHHHD    T9^              -7T5\n" +
                    "                        `                                                                             `\n" +
                    "    `         `                         `               `");

            input.getEnter();
        }
        else if(type == 2){
            output.printSystem("～数日後～");
            output.printSystem("「名前を失う」というのは本当らしく、");
            output.printSystem("家族や友人の誰もが名前を忘れていました。");
            output.printSystem("書物からも消えている徹底ぶりです。");

            input.getEnter();

            output.printSystem("あなたの周りには杖によって生まれた「文字」が戯れていて、");
            output.printSystem("ペットみたいで見ていて面白いですが、");
            output.printSystem("名前が無いと言うのは普通に不便です。");

            input.getEnter();

            output.printSystem("そこであなたは思い出します。");
            output.printSystem("前に読んだREAD MEは一部が欠損していたこと。");
            output.printSystem("杖を拾ったダンジョンにはまだ続きがあったこと。");

            input.getEnter();

            output.printSystem("もしかしたらあそこに名前を取り戻す手がかりがあるかも。");
            output.printSystem("あなたは、再びダンジョンに向けて出発しました。");
            output.printSystem("小さな仲間たちと名操の杖を携えて...");

            input.getEnter();

            output.printSystem("～～～名前バトルゲーム「名操の杖」遊び方～～～\n");
            output.printSystem("あなたは名前を取り戻すべく" + ANSI_BOLD + "ダンジョンの最奥部を目指します。" + ANSI_RESET);
            output.printSystem("しかし、各フロアには敵が立ちはだかっていて突破は困難です。");
            output.printSystem("駆け出し冒険者である貴方はボコボコにされてしまうでしょう。");

            input.getEnter();

            output.printSystem("そこで、名操の杖によって召喚した文字たちに戦ってもらいます。");
            output.printSystem("各文字には" + ANSI_BOLD + "個性があり、" + ANSI_RESET + "それぞれ " + ANSI_BOLD + "魔法を扱うことができます。" + ANSI_RESET);
            output.printSystem("敵を倒すと１文字だけ" + ANSI_BOLD + "強化することもできます。" + ANSI_RESET);

            input.getEnter();

            output.printSystem("敵を攻撃して体力を0にすれば勝利できます。");
            output.printSystem("また、15秒間耐える事でも疲労で勝利したことになります。");
            output.printSystem("ダンジョン地下5階を目指して頑張ろう！");

            input.getEnter();

        }
        else if(type == 3){
            output.printSystem("～エンディング～");
            output.printSystem("なんとか、あなたは地下5階に辿り着くことができました。");
            output.printSystem("そこには杖が入っていた箱と同じ見た目の箱がありました");

            input.getEnter();

            output.printSystem("開けてみると、欠けていたREAD MEの紙片が...。");
            output.printSystem("あなたはその内容を読んでみることにします。");

            input.getEnter();

            output.printSystem("使い方②：");
            output.printSystem("杖の使用を止める際は、底部のスイッチを押してください。");
            output.printSystem("文字は消え、使用者の名前は元に戻ります。");

            input.getEnter();

            output.printSystem("えっ？");

            input.getEnter();

            output.printSystem("...カチッ");

            input.getEnter();

            output.printCharacter("...なんてこったい！");

            input.getEnter();

            output.printCharacter("めでたしめでたし");
            output.printSystem("Thank You For Playing!");

            input.getEnter();

            output.printSystem("※ここからはエンドレスモードになります！");
            output.printSystem("　どこまでも続くダンジョンを踏破し、");
            output.printSystem("　あなたの名前の強さを証明しよう！！！");

            input.getEnter();

        }
        else if(type == 444){

            input.getEnter();

            output.printSystem("～ゲームオーバー～");
            output.printSystem("文字たちが倒されていまい、");
            output.printSystem("あなたは魔物の一撃で地にひれ伏してしまう。");
            output.printSystem("誰にも知られることなく、ここで冒険が終わるのだと直感する。");
            output.printSystem("あぁ、もっと強い名前を持っていれば...\n");

            output.printSystem("また一人、このダンジョンで無名の冒険者が行方不明になるのだった...");
            output.printSystem("Thank You For Playing!");
        }
    }
}
