package za.co.wethinkcode.swingy.view.Gui;

import za.co.wethinkcode.swingy.view.Gui.DetailEvent;
import za.co.wethinkcode.swingy.view.Gui.DetailListener;
import za.co.wethinkcode.swingy.view.Gui.DetailsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//visual guide swing layout

public class MainFrame extends JFrame {

    private DetailsPanel detailsPanel;

    public MainFrame(String title){
        super(title);

        //Set layout manager
        setLayout(new BorderLayout());//basic layout

        //Create Swing Component
        final JTextArea textArea = new JTextArea();
        JButton button = new JButton("Start Game");

        detailsPanel = new DetailsPanel();

        detailsPanel.addDetailListener(new DetailListener() {
            public void detailEventOccurred(DetailEvent event){
                String text = event.getText();
                textArea.setText(text);

            }
        });


        //and swing components to content pane
        Container c = getContentPane();


        c.add(textArea, BorderLayout.CENTER); //constants for where they should go
        c.add(button, BorderLayout.SOUTH);
        c.add(detailsPanel, BorderLayout.WEST);

        //add behavior
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Hello\n");
                detailsPanel.setVisible(false);
            } //this is an interface

        });
    }


}
