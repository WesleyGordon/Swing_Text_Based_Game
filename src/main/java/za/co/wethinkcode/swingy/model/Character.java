package za.co.wethinkcode.swingy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    public String name;
    public String type; //class
    protected int attack;
    protected int defence;
    protected int hp;
    protected int x;
    protected int y;
    public int level;
    public int xp;

    public Character(){
        this.hp = 100;
    }

    abstract public void attack(Character character);
    abstract public void defend(Character character, int damage);
}
