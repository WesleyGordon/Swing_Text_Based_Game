package za.co.wethinkcode.swingy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Continue extends JFrame{
    private JButton selectButton;
    private JButton backButton;

    private JSpinner selectSpinner;

    private JTextArea savedGames;

    private JPanel rootPanelContinue;

    public Continue(){
        super("hello world");
        setContentPane(rootPanelContinue);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start startPanel = new Start();
                setVisible(false);
            }
        });
    }
}
