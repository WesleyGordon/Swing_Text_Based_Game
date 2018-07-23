package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.model.characters.Enemy;
import za.co.wethinkcode.swingy.view.Battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BattleController {
    Battle battleView = new Battle();
    Enemy enemy;

    public BattleController(Enemy enemy){
        this.enemy = enemy;
        initListeners();
    }

    public void initListeners(){

        battleView.getBattleLog().setText("Do you wanna attack or flee?");
        battleView.getPlayerAttack().setText(Integer.toString(MainGameController.player.getAttack()));
        battleView.getPlayerDefence().setText(Integer.toString(MainGameController.player.getDefence()));
        battleView.getPlayerHealth().setText(Integer.toString(MainGameController.player.getHp()));
        battleView.getEnemyAttack().setText(Integer.toString(enemy.getAttack()));
        battleView.getEnemyDefence().setText(Integer.toString(enemy.getDefence()));
        battleView.getEnemyHealth().setText(Integer.toString(enemy.getHp()));

        battleView.getAttackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleView.getFleeButton().setEnabled(false);
                MainGameController.player.attack(enemy);

            }
        });

        battleView.getFleeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int random = new Random().nextInt(2);
                switch (random){
                    case 1:
                        battleView.getBattleLog().setText("You were unable to flee you have to fight!");
                        battleView.getFleeButton().setEnabled(false);
                        break;
                    case 0:
                        battleView.dispose();
                }
            }
        });
    }
}
