package za.co.wethinkcode.swingy.view.Gui;

import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiView extends JFrame {

    public static void run(){
        final JFrame jFrame = new JFrame("Swingy");
        JButton btn = new JButton("Next");
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                final JFrame jFrame2 = new MainFrame("Swingy");
                jFrame2.setVisible(true);
                jFrame2.setSize(600, 400);
                jFrame2.setDefaultCloseOperation(jFrame2.EXIT_ON_CLOSE);
            }
        });


        jFrame.setSize(600, 400);

        jFrame.setVisible(true);
    }
}
