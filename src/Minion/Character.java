package Minion;

public class Character {
    private int characterNumber;
    private int health;
    private int attack;
    private int speed;

    public Character(int characterNumber, int health, int attack, int speed){
        this.characterNumber = characterNumber;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }

    public int getCharacterNumber(){
        return this.characterNumber;
    }

    public int getHealth(){
        return this.health;
    }

    public int getAttack(){
        return this.attack;
    }

    public int getSpeed(){
        return this.speed;
    }
}
