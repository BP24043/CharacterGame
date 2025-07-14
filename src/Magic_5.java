public class Magic_5 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        magicianCharacter.setHealthByYourSelf(1);
        magicianCharacter.setAttackByYourSelf(magicianCharacter.getAttack() * magicianCharacter.getMagicPower());
    }
}
