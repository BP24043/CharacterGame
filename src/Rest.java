import javax.xml.crypto.Data;

public class Rest {

    Input input = new Input();
    Output output = new Output();


    public void noRest(){
        while(true){
            int choice = input.getAction_1();
            if(choice == 1){ //ステータス確認
                showMoji();
            }
            if(choice == 2){ //次に進む
                break;
            }
        }
    }

    public boolean Rest(){
        while(true){
            int choice = input.getAction_2();
            if(choice == 1){ //ステータス確認
                showMoji();
            }
            if(choice == 2){ //次に進む
                break;
            }
            if(choice == 3){ //強化する
                if(upGrade()){
                    return true;
                }
            }
        }
        return false;
    }

    public void showMoji(){
        output.printSystem("仲間の情報");

        output.printSystem("名前　　　　" + "体力　　" + "攻撃力　" + "素早さ　" + "魔法コスト" + "  魔法効力" + "　　魔法");

        String dataFormat = "%-7s%7d%7d%7d%7d%7d";

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
                    character.getMagicCost(),
                    character.getMagicPower()
            );

            status += "　　　　" + DataLoader.getInstance().getMagicNameData(character.getMagic());

            output.printSystem(status);
        }
        output.printSystem("");
    }

    public boolean upGrade(){
        Input input = new Input();

        showMoji();
        output.printSystem("どの文字を強化する？");

        char inputChar = input.getInput_1moji();
        if(inputChar == 'q'){
            return false;
        }

        if(!(java.lang.Character.isDigit(inputChar)))
            return false;

        int characterNumber = Integer.parseInt(String.valueOf(inputChar));
        Character character = CharacterGenerate.getInstance().getCharacter(characterNumber - 1);
        if(character == null){
            return false;
        }

        output.printSystem("何を強化する？");
        inputChar = input.getInput_1moji_2();
        if(inputChar == 'q'){
            return false;
        }

        if(inputChar == 'た'){
            character.setHealthByYourSelf(character.getHealth() * 2);
        }
        else if(inputChar == 'こ'){
            character.setAttackByYourSelf(character.getAttack() * 2);
        }
        else if(inputChar == 'す'){
            character.setSpeedByYourSelf(character.getSpeed() * 2);
        }
        else if(inputChar == 'い'){
            character.setMagicPowerByYourSelf(character.getMagicPower() + 1);
        }
        else if(inputChar == 'ま'){
            character.setMagicCostByYourSelf(character.getMagicCost() - 1);
        }
        else{
            return false;
        }
        return true;
    }
}
