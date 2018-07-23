package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.model.characters.Enemy;
import za.co.wethinkcode.swingy.view.Game;
import za.co.wethinkcode.swingy.view.Map;
import za.co.wethinkcode.swingy.view.Start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {

    Game gameView = new Game(MainGameController.player);
    Map map = new Map(MainGameController.player);
    EnemyController enemyController = new EnemyController();



    public GameController() {
        initListeners();
        enemyController.initEnemies(map);
        map.populateMap();
        map.printMap(gameView.getGameplayLog());
    }

    public void initListeners() {
        gameView.getNorthButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainGameController.player.getX() > 0) {
                    Map.map[MainGameController.player.getX()][MainGameController.player.getY()] = " ";
                    MainGameController.player.setX(MainGameController.player.getX() - 1);
                    enemyController.moveEnemies(map);
                    map.populateMap();
                    map.printMap(gameView.getGameplayLog());
                    checkCollide();


                }
            }
        });

        gameView.getEastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainGameController.player.getY() < Map.mapSize - 1) {
                    Map.map[MainGameController.player.getX()][MainGameController.player.getY()] = " ";
                    MainGameController.player.setY(MainGameController.player.getY() + 1);
                    enemyController.moveEnemies(map);
                    map.populateMap();
                    map.printMap(gameView.getGameplayLog());
                    checkCollide();

                }
            }
        });

        gameView.getWestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainGameController.player.getY() > 0) {
                    Map.map[MainGameController.player.getX()][MainGameController.player.getY()] = " ";
                    MainGameController.player.setY(MainGameController.player.getY() - 1);
                    enemyController.moveEnemies(map);
                    map.populateMap();
                    map.printMap(gameView.getGameplayLog());
                    checkCollide();

                }
            }
        });
        gameView.getSouthButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainGameController.player.getX() < Map.mapSize - 1) {
                    Map.map[MainGameController.player.getX()][MainGameController.player.getY()] = " ";
                    MainGameController.player.setX(MainGameController.player.getX() + 1);
                    enemyController.moveEnemies(map);
                    map.populateMap();
                    map.printMap(gameView.getGameplayLog());
                    checkCollide();

                }
            }
        });
        gameView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartController startController = new StartController();
                gameView.dispose();
                //gameView.setVisible(false);
            }
        });
    }

    void checkCollide(){
        for (Enemy e: MainGameController.enemyList) {
            if (e.getX() == MainGameController.player.getY() && e.getY() == MainGameController.player.getX()){
                BattleController battleController = new BattleController(e);
            }

        }
    }
}

