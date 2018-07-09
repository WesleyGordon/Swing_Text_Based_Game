package za.co.wethinkcode.swingy.view;

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
        JButton button = new JButton("Click Me");

        detailsPanel = new DetailsPanel();

        detailsPanel.addDetailListener(new DetailListener() {
            public void detailEventOccurred(DetailEvent event){
                String text = event.getText();

                textArea.append(text);

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
            } //this is an interface

        });
    }
}
