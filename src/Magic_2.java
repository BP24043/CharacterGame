public class Magic_2 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        for(Character childCharacter: allCharacter){
            childCharacter.setAttackByYourSelf(childCharacter.getAttack() * magicianCharacter.getMagicPower());
        }
    }
}
