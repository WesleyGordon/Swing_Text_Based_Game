package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.controller.MainGameController;
import za.co.wethinkcode.swingy.model.Character;

@Getter
@Setter
public abstract class Hero extends Character {

    private String weapon;
    private String armour;
    private String helm;

    Hero(){

    }

    Hero(String name, String weapon, String armour, String helm, int attack, int defence){
        this.name = name;
        this.xp = 0;
        this.level = 1;
        this.weapon = weapon;
        this.armour = armour;
        this.helm = helm;
        this.attack = attack;
        this.defence = defence;
    }

    Hero(String name, int level, int xp, String weapon, String armour, String helm, int attack, int defence){
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.weapon = weapon;
        this.armour = armour;
        this.helm = helm;
        this.attack = attack + level;
        this.defence = defence + level;
    }

    public static Hero newHero(String name, String type, int level, int xp, String weapon, String armour, String helm){
        switch (type) {
            case "Monk":
                return(new Monk(name, level, xp, armour, weapon, helm));
            case "Sorcerer":
                return(new Sorcerer(name, level, xp, armour, weapon, helm));
            case "Scout":
                return(new Scout(name, level, xp, armour, weapon, helm));
            default:
                System.out.println("Invalid Hero");
                return (null);
        }
    }

    public static Hero newHero(String name, String type){
        switch (type) {
            case "Monk":
                return(new Monk(name));
            case "Sorcerer":
                return(new Sorcerer(name));
            case "Scout":
                return(new Scout(name));
            default:
                System.out.println("Invalid Hero");
                return (null);
        }
    }

    @Override
    public void attack(Character character) {
        character.defend(character, this.attack);
    }
}
