public class Magic_3 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        magicianCharacter.setSpeedByYourSelf((int)(magicianCharacter.getSpeed() * 0.5));
        magicianCharacter.setAttackByYourSelf(magicianCharacter.getAttack() * magicianCharacter.getMagicPower());
    }
}
