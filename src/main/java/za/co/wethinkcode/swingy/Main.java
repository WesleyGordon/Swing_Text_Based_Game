package za.co.wethinkcode.swingy;

import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.Monk;
import za.co.wethinkcode.swingy.view.Cli.CliView;
import za.co.wethinkcode.swingy.view.Gui.GuiView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Hero> heroList = new ArrayList<Hero>();

    public static void main(String[] args){
        readToList();
        try {
        switch(args[0].toLowerCase())
        {
            case "console":
                CliView.run();
                break;
            case "gui":
                GuiView.run();
                break;
        }
        }catch(Exception e){
            System.out.println(e.toString());
            System.out.println("There was an error in the program");
        }
    }

    public static void readToList(){
        String type;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("heroes.txt"));
            String line = reader.readLine();
            if (line != null) {
                while ((line = reader.readLine()) != null) {
                    Hero hero = Hero.newHero(line.split(",")[0], line.split(",")[1],
                            Integer.parseInt(line.split(",")[2]), Integer.parseInt(line.split(",")[3]),
                            line.split(",")[4], line.split(",")[5], line.split(",")[6]);
                    heroList.add(hero);
                }

            }
        }catch (IOException e){

        }
        Hero chara = new Monk();
        heroList.add(chara);
    }
}
