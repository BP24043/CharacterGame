public class Magic_6 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        for(Character childCharacter: allCharacter){
            childCharacter.setHealthByYourSelf((int)(childCharacter.getHealth() * 0.5));
            childCharacter.setSpeedByYourSelf(childCharacter.getSpeed() + magicianCharacter.getMagicPower());
        }
    }
}
