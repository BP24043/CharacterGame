
public class Rest {

    Input input = new Input();
    Output output = new Output();

    public void noRest(){
        while(true){
            int choice = input.getAction_1();
            if(choice == 1){
                output.printSystem("仲間の情報");

                output.printSystem("名前　　　　" + "体力　　" + "攻撃力　" + "素早さ　" + "魔法コスト" + "　　魔法");

                String dataFormat = "%-6s%6d%6d%6d%6d";

                for(int i = 0; i < CharacterGenerate.getInstance().getCHARACTER_MAX(); i++){
                    Character character = CharacterGenerate.getInstance().getCharacter(i);
                    if(character == null)
                        break;

                    String status = String.format(
                            dataFormat,
                            character.getName(),
                            character.getHealth(),
                            character.getAttack(),
                            character.getSpeed(),
                            character.getMagicCost()
                    );

                    status += "　　　　　　　魔法の名前" + character.getMagic();

                    output.printSystem(status);
                }
            }
            if(choice == 2){
                break;
            }
        }
    }
}
