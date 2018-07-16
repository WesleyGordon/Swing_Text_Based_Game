package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Character;

@Getter
@Setter
public class Scout extends Hero{
    private String weapon = "Wooden Dagger";
    private String armour = "Leather Vest";
    private String helm = "Leather Helmet";

    Scout(String name){
        super(name);
    }

    Scout(String name, int level, int xp, String weapon, String armour, String helm)
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
