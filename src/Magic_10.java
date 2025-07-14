public class Magic_10 implements Magic{
    public void useMagic(Character[] allCharacter, Character magicianCharacter){
        for(Character childCharacter: allCharacter){
            childCharacter.setHealthByYourSelf(childCharacter.getHealth() * magicianCharacter.getMagicPower());
        }
        magicianCharacter.setSpeedByYourSelf(3);
    }
}

/*
番号,名前,前メッセージ,単位,効力,後メッセージ
0,一致団結だ！,リーダーシップにより全員の攻撃力が,＋,2,上昇！
1,力を分けてくれーっ！,勝手に味方の攻撃力を吸い取って攻撃力,✕,2,上昇！
2,背水の陣,捨て身の構えで敵味方共に攻撃力,✕,4,上昇！
3,渾身の一撃,自身の素早さを半分にし、一撃に集中して攻撃力が,✕,4,上昇！
4,暴走,自身の体力を1まで削り、自身の攻撃力を削った分,✕,1,上昇！
5,一喝,声かけで全員の素早さを,＋,1,上昇！
6,畳み掛け,全員の体力を半分にして、全員の素早さを,＋,4,上昇！
7,憑依,自身の素早さを1に固定し、全員の素早さを,＋,4,上昇！
8,全体回復,全員の体力を,＋,10,した！
9,超回復,全員の体力を,✕,2,した！
10,延命,自身の素早さを3に固定し、自身の体力を,✕,4,にした！
 */