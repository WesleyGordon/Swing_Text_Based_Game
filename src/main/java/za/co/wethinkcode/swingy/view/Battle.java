package za.co.wethinkcode.swingy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Battle extends JFrame {
    private JTextArea battleLog;

    private JButton attackButton;
    private JButton fleeButton;

    private JPanel rootPanelBattle;
    private JPanel enemyPanel;
    private JPanel playerPanel;
    private JPanel battlePanel;

    private JLabel enemyHealth;
    private JLabel playerHealth;
    private JLabel enemyAttack;
    private JLabel playerAttack;
    private JLabel enemyDefence;
    private JLabel playerDefence;

    public Battle() {
        super("hello world");
        setContentPane(rootPanelBattle);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);



        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
