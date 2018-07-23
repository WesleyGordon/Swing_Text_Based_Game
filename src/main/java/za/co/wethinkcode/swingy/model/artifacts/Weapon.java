package za.co.wethinkcode.swingy.model.artifacts;

import lombok.Getter;
import za.co.wethinkcode.swingy.model.Artifact;

@Getter
public class Weapon extends Artifact {
    private int attack;

    public Weapon(String name, int attack) {
        super(name);
        this.type = "Weapon";
        this.attack = attack;
    }
}
