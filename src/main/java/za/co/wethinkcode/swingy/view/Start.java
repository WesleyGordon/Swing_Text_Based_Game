package za.co.wethinkcode.swingy.view;

import za.co.wethinkcode.swingy.Main;
import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.Monk;
import za.co.wethinkcode.swingy.model.characters.Scout;
import za.co.wethinkcode.swingy.model.characters.Sorcerer;
import za.co.wethinkcode.swingy.view.Gui.GuiView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Start extends JFrame{
    private JPanel rootPanelStart;
    private JPanel buttonPanel;
    private JPanel fieldPanel;

    private JButton newGameButton;
    private JButton continueButton;

    private JTextField nameTextArea;

    private JComboBox<String> heroTypeSelect;
    private JLabel header;

    public static PrintWriter writer;

    public Start(){
       super("hello world");

       setContentPane(rootPanelStart);
       pack();
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(600, 400);
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
       this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

       heroTypeSelect.addItem("Sorcerer");
       heroTypeSelect.addItem("Scout");
       heroTypeSelect.addItem("Monk");
       setVisible(true);

       newGameButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               Main.heroList.add(Hero.newHero(nameTextArea.getText(), heroTypeSelect.getSelectedItem().toString()));
               GuiView.startGame();
               Game gamePanel = new Game();
               setVisible(false);
               writer.close();

           }

       });

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Continue continuePanel = new Continue();
                setVisible(false);
            }
        });
    }


}
