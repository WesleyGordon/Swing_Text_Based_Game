package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.model.characters.Enemy;
import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.view.Start;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainGameController {
    public static List<Hero> heroList = new ArrayList<Hero>();
    public static List<Enemy> enemyList = new ArrayList<>();
    public static Hero player;
    public Save save = new Save();

    public static void GUIrun(){
        StartController startController = new StartController();
    }

    public static void CLIrun(){
        //

    }

    public static void readToList(){
        String type;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("heroes.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                Hero hero = Hero.newHero(line.split(",")[0], line.split(",")[1],
                        Integer.parseInt(line.split(",")[2]), Integer.parseInt(line.split(",")[3]),
                        line.split(",")[4], line.split(",")[5], line.split(",")[6]);
                heroList.add(hero);
            }
        }catch (IOException e){

        }
    }
}
