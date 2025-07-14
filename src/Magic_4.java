public class Magic_4 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        int oldHealth = magicianCharacter.getHealth();
        int sabunHealth = oldHealth - 1;
        magicianCharacter.setHealthByYourSelf(1);
        magicianCharacter.setAttackByYourSelf(magicianCharacter.getAttack() + sabunHealth * magicianCharacter.getMagicPower());
    }
}
