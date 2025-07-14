import javax.xml.crypto.Data;

public class CharacterGenerate {

    private static final CharacterGenerate INSTANCE = new CharacterGenerate();

    private static final int CHARACTER_MAX = 6;

    private static final String HIRAGANA_REGEX = "^[\\u3040-\\u309F]+$";


    //使用中の「文字」
    private Character[] character;
    //戦闘時に参照する「文字」
    private Character[] activeCharacter;

    public CharacterGenerate(){

    }

    public static CharacterGenerate getInstance(){
        return INSTANCE;
    }

    public boolean ResetCharacter(String namae){
        character = new Character[CHARACTER_MAX];
        if(namae.length() <= CHARACTER_MAX && namae.matches(HIRAGANA_REGEX)){
            for(int i = 0; i < namae.length(); i++){
                Generate(String.valueOf(namae.charAt(i)));
            }
            return true;
        }
        return false;
    }

    public void Generate(String moji){

        if(moji.length() != 1){
            System.err.println("２文字以上の引数渡してくるんじゃねぇ！");
            return;
        }

        for(int i = 0; i < DataLoader.getInstance().getHIRAGANA_COUNT(); i++){
            if(moji.equals(DataLoader.getInstance().getNameData(i))){
                for(int j = 0; j < CHARACTER_MAX; j++){
                    if(character[j] == null){
                        character[j] = new Character(i,DataLoader.getInstance().getNameData(i),DataLoader.getInstance().getHealthData(i),DataLoader.getInstance().getAttackData(i),DataLoader.getInstance().getSpeedData(i),DataLoader.getInstance().getMagicData(i),DataLoader.getInstance().getMagicCostData(i),DataLoader.getInstance().getMagicPowerData(DataLoader.getInstance().getMagicData(i)));
                        break;
                    }
                }
            }
        }
    }

    public Character getCharacter(int number) {
        if (number < CHARACTER_MAX && character[number] != null) {
            return character[number];
        }
        return null;
    }
    public int getCHARACTER_MAX(){
        return CHARACTER_MAX;
    }

    public Character[] getCharacters(){
        activeCharacter = new Character[character.length];
        for(int i = 0; i < character.length; i++){
            if(character[i] != null)
                activeCharacter[i] = new Character(character[i]);
        }
        return activeCharacter;
    }


}
