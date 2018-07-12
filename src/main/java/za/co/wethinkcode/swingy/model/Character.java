package za.co.wethinkcode.swingy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected String type; //class
    protected int attack;
    protected int defence;
    protected int hp;
    protected int x;
    protected int y;
    protected int level;
    protected int exp;

    public void Character(){


    }

    abstract public void attack(Character character);
    abstract public void defend(Character character, int damage);
}
