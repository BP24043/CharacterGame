public class Magic_9 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        for(Character childCharacter: allCharacter){
            childCharacter.setHealthByYourSelf(childCharacter.getHealth() * magicianCharacter.getMagicPower());
            System.err.println(childCharacter.getHealth());
        }
    }
}
