public class Magic_0 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        for(Character childCharacter: allCharacter){
            childCharacter.setAttackByYourSelf(childCharacter.getAttack() + magicianCharacter.getMagicPower());
        }
    }
}
