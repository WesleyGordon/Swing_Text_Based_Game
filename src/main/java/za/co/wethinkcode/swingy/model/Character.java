package za.co.wethinkcode.swingy.model;

import za.co.wethinkcode.swingy.model.artifacts.*;

public class Character {
    private String name;
    private String type; //class
    private int level;
    private int exp;

    public void Character(String name, String type, int level, int exp, Weapon weapon, Armour armour){
        this.name = name;
        this.type = type;
        this.level = level;
        this.exp = exp;

    }
}
