package za.co.wethinkcode.swingy.controller;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import za.co.wethinkcode.swingy.Colors;
import za.co.wethinkcode.swingy.Main;
import za.co.wethinkcode.swingy.model.characters.Enemy;
import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.view.Game;
import za.co.wethinkcode.swingy.view.Map;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;


public class CliController {

    public static Scanner scanner = new Scanner(System.in);
    public static Map map;
    public static EnemyController enemyController = new EnemyController();

    public void CliController(){

    }


    public static void start(){
        while(true) {
            System.out.print("\033[H\033[2J");
            printMenu();
            System.out.print(Colors.GREEN + "N/C: " + Colors.RESET);
            String option = scanner.nextLine();
            if (option.toLowerCase().equals("n")) {
                MainGameController.newGame(createNewHero());
                map = new Map(MainGameController.player);
                enemyController.initEnemies(map);
                System.out.print("\033[H\033[2J");
                System.out.flush();
                gamePlay();
            } else if (option.toLowerCase().equals("c")) {
                printContinueGame();
                map = new Map(MainGameController.player);
                enemyController.initEnemies(map);
                System.out.print("\033[H\033[2J");
                System.out.flush();
                gamePlay();
            } else {
                System.out.println(Colors.RED + "Invalid input." + Colors.RESET);
            }
        }
    }


    public static Hero createNewHero(){
        String name = "";
        String type = "";
        while(name.equals("")) {
            System.out.println(Colors.YELLOW +  "Type your name: " );
            System.out.print(Colors.GREEN + "Name: " + Colors.RESET);
            name = scanner.nextLine();
            while(true){
                System.out.println(Colors.YELLOW +  "Select a hero: " );
                System.out.print(Colors.GREEN + "Sorcerer/Scout/Monk: " + Colors.RESET);
                type = scanner.nextLine();
                if (type.toLowerCase().equals("scout") || type.toLowerCase().equals("sorcerer") || type.toLowerCase().equals("monk")){
                    type.toLowerCase();
                    type = type.substring(0, 1).toUpperCase() + type.substring(1);
                    break;
                }
            }
        }
        return (Hero.newHero(name, type));
    }

    public static void gamePlay(){
        map.populateMap();
        while(true) {
            printStats();
            switch (printMoveMenu().toUpperCase()) {
                case "N":
                    MainGameController.player.moveNorth(map, enemyController);
                    doChecks();
                    break;
                case "E":
                    MainGameController.player.moveEast(map, enemyController);
                    doChecks();
                    break;
                case "S":
                    MainGameController.player.moveSouth(map, enemyController);
                    doChecks();
                    break;
                case "W":
                    MainGameController.player.moveWest(map, enemyController);
                    doChecks();
                    break;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    //VIEWS

    public static void printBattleStats(Enemy en){
        System.out.println(Colors.CYAN + "\nYour stats:");
        System.out.println("Attack: " + MainGameController.player.getAttack());
        System.out.println("Defence: " + MainGameController.player.getDefence() + '\n');
        System.out.println("Enemy stats:");
        System.out.println("Type: " + en.getClass().getSimpleName());
        System.out.println("Attack: " + en.getAttack());
        System.out.println("Defence: " + en.getDefence());
    }

    public static String printMoveMenu(){
        System.out.println(Colors.PURPLE +  "North (N): " );
        System.out.println("East (E): ");
        System.out.println("South (S): ");
        System.out.println("West (W): "+ Colors.RESET);
        System.out.print(Colors.GREEN + "N/E/S/W: "+ Colors.RESET);
        String direction = scanner.nextLine();
        return (direction);
    }

    public static void printStats(){
        System.out.println("\n_________________________\n");
        System.out.println(Colors.YELLOW +  "Name: " + MainGameController.player.getName());
        System.out.println( "Type: " + MainGameController.player.getClass().getSimpleName() + "\n");
        System.out.println( "Level: " + MainGameController.player.getLevel());
        System.out.println("XP: " + MainGameController.player.getXp());
        System.out.println("Armour: "+ MainGameController.player.getArmour());
        System.out.println("Weapon: "+ MainGameController.player.getWeapon());
        System.out.println("Helm: "+ MainGameController.player.getHelm());

        map.printMap();
    }

    public static void printMenu() {
        System.out.println(Colors.YELLOW +  "Welcome to Swingy! Select an option: " );
        System.out.println("_________________________");
        System.out.println("N: New Game.");
        System.out.println("C: Continue. "+ Colors.RESET);


    }

    public static void printContinueGame(){
        int option = MainGameController.heroList.size() + 5;
        while(option > MainGameController.heroList.size() - 1){
        int i = 0;
        System.out.println(Colors.YELLOW +  "Select a saved hero: " );
        for (Hero hero:MainGameController.heroList) {
            System.out.println(Colors.GREEN + i + ": " + hero.getName() + "\t\t\tType: " + hero.getClass().getSimpleName() + "\t\t\tLevel: " + hero.getLevel() + "\t\t\tExperience: " + hero.getXp());
            i++;
        }
        System.out.println("Choose a number between 0 and " + (MainGameController.heroList.size() - 1) + ":");
        option = Integer.parseInt(scanner.nextLine());
        }
        MainGameController.player = MainGameController.heroList.get(option);
    }

    public static void doChecks(){
        Enemy en = MainGameController.checkCollide();
        if (en != null){
            System.out.println(Colors.RED + "You have encountered an enemy. \nBattle(B) or Flee(F)?");
            printBattleStats(en);
            switch (scanner.nextLine().toUpperCase()){
                case "B":
                    battle(en);
                    break;
                case "F":
                    attemptFlee(en);
                    break;
            }
        }
        if(MainGameController.checkWin()){
            System.out.println(Colors.PURPLE + "Y" + Colors.RED + "O" + Colors.CYAN +"U" + Colors.YELLOW + " W" + Colors.RED + "I" + Colors.CYAN +  "N" );
            System.exit(0);
        }
    }

    public static void battle(Enemy en){
        int enemyHP;
        int playerHP = 0;
        while (true) {
            if (MainGameController.player.getHp()  <= 0) {
                System.out.println("YOU DIED!");
                MainGameController.player.setHp(0);
                System.exit(0);
                break;
            }
            else if (en.getHp() <= 0) {
                System.out.println("You have destroyed the enemy.");
                MainGameController.enemyList.remove(en);
                en.setHp(0);
                MainGameController.player.setHp(100);
                MainGameController.player.updateStats();

                System.out.print(Colors.GREEN + "Press any key to continue.");
                scanner.nextLine();
                break;
            }
            else {
                MainGameController.player.attack(en);
                enemyHP = en.getHp();
                if (enemyHP <= 0){
                    enemyHP = 0;
                }else{
                    System.out.print(Colors.RED + "Player attacked enemy with " + MainGameController.player.getAttack() + " attack.\n Enemy hp is now " + enemyHP + "\n");
                    en.attack(MainGameController.player);
                    playerHP = MainGameController.player.getHp();
                    if (playerHP < 0){
                        playerHP = 0;
                    }
                    System.out.print(Colors.GREEN + "Enemy attacked player with " + en.getAttack() + " attack.\n Player hp is now " + playerHP + "\n");
                }
            }
        }
    }

    public static void attemptFlee(Enemy en){
        int random = new Random().nextInt(2);
        switch (random){
            case 1:
                System.out.println(Colors.RED + "You were unable to flee you have to fight!");
                battle(en);
                break;
            case 0:
                break;
        }
    }

}
