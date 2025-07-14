public class Magic_7 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        for(Character childCharacter: allCharacter){
            childCharacter.setSpeedByYourSelf(childCharacter.getSpeed() + magicianCharacter.getMagicPower());
        }
        magicianCharacter.setSpeedByYourSelf(1);
    }
}
