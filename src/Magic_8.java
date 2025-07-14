public class Magic_8 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        for(Character childCharacter: allCharacter){
            childCharacter.setHealthByYourSelf(childCharacter.getHealth() + magicianCharacter.getMagicPower());
        }
    }
}
