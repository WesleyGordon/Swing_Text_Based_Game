package za.co.wethinkcode.swingy;

import za.co.wethinkcode.swingy.controller.MainGameController;

public class Main {
    public static void main(String[] args){
        MainGameController.readToList();
        try {
        switch(args[0].toLowerCase()){
            case "console":
                MainGameController.CLIrun();
                break;
            case "gui":
                MainGameController.GUIrun();
                break;
        }
        }catch(Exception e){
            System.out.println(e.toString());
            System.out.println("There was an error in the program");
        }
    }
}
