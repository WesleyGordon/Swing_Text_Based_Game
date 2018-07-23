package za.co.wethinkcode.swingy.model.characters;

import za.co.wethinkcode.swingy.model.Character;

public class Dragon extends Enemy {

    public Dragon(int y, int x){
        super(20, 30);
        this.y = y;
        this.x = x;
    }

    @Override
    public void attack(Character character) {

    }

    @Override
    public void defend(Character character, int damage) {

    }
}
