package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Character;

@Getter
@Setter
public class Sorcerer extends Hero{
    private String weapon = "Wooden Magical Staff";
    private String armour = "Leather Vest";
    private String helm = "Leather Hood";

    Sorcerer(String name){
        super(name);
    }

    Sorcerer(String name, int level, int xp, String weapon, String armour, String helm)
    {
        super(name, level, xp, weapon, armour, helm);
    }

    @Override
    public void attack(Character character) {

    }

    @Override
    public void defend(Character character, int damage) {

    }
}
