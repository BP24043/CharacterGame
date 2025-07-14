
public class Character {
    private int characterNumber;
    private String name;
    private int health;
    private int attack;
    private int speed;
    private int magic;
    private int magicCost;
    private int magicPower;

    private int nowMagicCost;

    public Character(int characterNumber, String name, int health, int attack, int speed, int magic, int magicCost, int magicPower){
        this.characterNumber = characterNumber;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        this.magic = magic;
        this.magicCost = magicCost;
        this.magicPower = magicPower;
    }

    public Character(Character other){
        if(other != null){
            this.characterNumber = other.characterNumber;
            this.name = other.name;
            this.health = other.health;
            this.attack = other.attack;
            this.speed = other.speed;
            this.magic = other.magic;
            this.magicCost = other.magicCost;
            this.magicPower = other.magicPower;
        }
    }

    public Character(){

    }

    public int getCharacterNumber(){
        return this.characterNumber;
    }

    public void setCharacterNumber(int id){
        this.characterNumber = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(int id){
        this.name = DataLoader.getInstance().getNameData(id);
    }

    public void setNameByYourSelf(String name){
        this.name = name;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int id){
        this.health = DataLoader.getInstance().getHealthData(id);
    }

    public void setHealthByYourSelf(int health){
        this.health = health;
    }

    public int getAttack(){
        return this.attack;
    }

    public void setAttack(int id){
        this.attack = DataLoader.getInstance().getAttackData(id);
    }

    public void setAttackByYourSelf(int attack){
        this.attack = attack;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void setSpeed(int id){
        this.speed = DataLoader.getInstance().getSpeedData(id);
    }

    public void setSpeedByYourSelf(int speed){
        this.speed = speed;
    }

    public int getMagic(){
        return this.magic;
    }

    public void setMagic(int id){
        this.magic = DataLoader.getInstance().getMagicData(id);
    }

    public void setMagicByYourSelf(int magic){
        this.magic = magic;
    }

    public int getMagicCost(){
        return this.magicCost;
    }

    public void setMagicCost(int id){
        this.magicCost = DataLoader.getInstance().getMagicCostData(id);
    }

    public void setMagicCostByYourSelf(int magicCost){
        this.magicCost = magicCost;
    }

    public int getNowMagicCost(){
        return nowMagicCost;
    }

    public void setNowMagicCost(int i){
        if(i == 0){ //0が渡されたら0にする
            nowMagicCost = 0;
        }
        else{
            nowMagicCost += i;
        }
    }

    public void setMagicPower(int id){
        this.magicPower = DataLoader.getInstance().getMagicData(id);
    }

    public void setMagicPowerByYourSelf(int magicPower){
        this.magicPower = magicPower;
    }

    public int getMagicPower(){
        return magicPower;
    }
}
