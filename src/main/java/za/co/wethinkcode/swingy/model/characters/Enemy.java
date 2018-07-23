package za.co.wethinkcode.swingy.model.characters;

import za.co.wethinkcode.swingy.model.Character;

public abstract class Enemy extends Character{

    public Enemy(int attack, int defence){
        this.attack = attack;
        this.defence = defence;
    }

    public static Enemy newEnemy(String type, int y, int x){
        switch (type) {
            case "Dragon":
                return(new Dragon(y, x));
            case "Pegasus":
                return(new Pegasus(y, x));
            case "Werewolf":
                return(new Werewolf(y, x));
            default:
                System.out.println("Invalid Enemy");
                return (null);
        }
    }

    @Override
    public void defend(Character character, int damage) {
        int finalDamage = damage - character.getArmour();
        this.hp -= finalDamage;
    }
}
