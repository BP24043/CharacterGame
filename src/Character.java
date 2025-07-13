public class Character {
    private int characterNumber;
    private String name;
    private int health;
    private int attack;
    private int speed;
    private int magic;
    private int magicCost;

    public Character(int characterNumber, String name, int health, int attack, int speed, int magic, int magicCost){
        this.characterNumber = characterNumber;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        this.magic = magic;
        this.magicCost = magicCost;
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

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int id){
        this.health = DataLoader.getInstance().getHealthData(id);
    }

    public int getAttack(){
        return this.attack;
    }

    public void setAttack(int id){
        this.attack = DataLoader.getInstance().getAttackData(id);
    }

    public int getSpeed(){
        return this.speed;
    }

    public void setSpeed(int id){
        this.speed = DataLoader.getInstance().getSpeedData(id);
    }

    public int getMagic(){
        return this.magic;
    }

    public void setMagic(int id){
        this.magic = DataLoader.getInstance().getMagicData(id);
    }

    public int getMagicCost(){
        return this.magicCost;
    }

    public void setMagicCost(int id){
        this.magicCost = DataLoader.getInstance().getMagicCostData(id);
    }
}
