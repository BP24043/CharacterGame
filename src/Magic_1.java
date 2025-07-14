public class Magic_1 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        for(Character childCharacter: allCharacter){
            childCharacter.setAttackByYourSelf((int) (childCharacter.getAttack() * 0.5));
        }
        magicianCharacter.setAttackByYourSelf((int) (magicianCharacter.getAttack() * 2));
        magicianCharacter.setAttackByYourSelf((int) (magicianCharacter.getAttack() * magicianCharacter.getMagicPower()));
    }
}
