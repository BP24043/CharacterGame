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
        else if(type == 1){
            output.printSystem("～開幕～\n");
        }
        else if(type == 2){

        }
    }
}
