package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Character;

@Getter
@Setter
public class Sorcerer extends Hero{

    Sorcerer(String name){
        super(name, "Wooden", "Leather", "Leather",35,25);
    }

    Sorcerer(String name, int level, int xp, String weapon, String armour, String helm)
    {
        super(name, level, xp, weapon, armour, helm, 35, 25 );
    }

    @Override
    public void attack(Character character) {

    }

    @Override
    public void defend(Character character, int damage) {

    }
}
