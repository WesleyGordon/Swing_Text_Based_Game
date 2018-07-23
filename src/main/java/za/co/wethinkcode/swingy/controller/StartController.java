package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.Main;
import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.view.Continue;
import za.co.wethinkcode.swingy.view.Game;
import za.co.wethinkcode.swingy.view.Start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartController {

    public Start startView = new Start();
    public Save save = new Save();

    public StartController(){
        initListeners();

    }

    public void initListeners(){
        startView.getNewGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Hero hero = Hero.newHero(startView.getNameTextArea().getText(), startView.getHeroTypeSelect().getSelectedItem().toString());
                MainGameController.heroList.add(hero);
                MainGameController.player = MainGameController.heroList.get(MainGameController.heroList.size() - 1);
                GameController gameController = new GameController();
                save.saveNewHero(hero);
//                startView.setVisible(false);
                startView.dispose();

            }

        });

        startView.getContinueButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ContinueController continueController = new ContinueController();
                startView.dispose();
                //startView.setVisible(false);
            }
        });

        startView.getNameTextArea().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (!startView.getNameTextArea().getText().equals("")) {
                    startView.getNewGameButton().setEnabled(true);
                }else if (startView.getNameTextArea().getText().equals("")) {
                    startView.getNewGameButton().setEnabled(false);
                }

            }
        });
    }

}
