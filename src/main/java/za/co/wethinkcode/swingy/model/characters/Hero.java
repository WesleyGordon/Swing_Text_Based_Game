package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Character;

@Getter
@Setter
public abstract class Hero extends Character {

    Hero(){

    }

    Hero (String name)
    {
        this.name = name;
        this.level = 1;
        this.exp = 0;
    }
}
