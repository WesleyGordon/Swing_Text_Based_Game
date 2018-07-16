package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Character;

@Getter
@Setter
public class Monk extends Hero{
    private String weapon = "Wooden Mace";
    private String armour = "Robe";
    private String helm = "";

    Monk(String name){
        super(name);
    }

    Monk(String name, int level, int xp, String weapon, String armour, String helm)
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
