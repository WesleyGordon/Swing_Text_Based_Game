package za.co.wethinkcode.swingy.view;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{
    private JButton northButton;
    private JButton southButton;
    private JButton westButton;
    private JButton eastButton;

    private JTextPane gameplayLog;

    private JPanel rootPanelGame;
    private JPanel leftPanel;
    private JPanel statsPanel;

    private JLabel xpLabel;
    private JLabel levelLabel;
    private JLabel helmLabel;
    private JLabel weaponLabel;
    private JLabel armourLabel;

    public Game(){
        super("hello world");
        setContentPane(rootPanelGame);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
    }
}
