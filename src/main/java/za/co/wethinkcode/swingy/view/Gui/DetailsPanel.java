package za.co.wethinkcode.swingy.view.Gui;

import za.co.wethinkcode.swingy.view.Gui.DetailEvent;
import za.co.wethinkcode.swingy.view.Gui.DetailListener;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsPanel extends JPanel {

    private EventListenerList listenerList = new EventListenerList();

    public DetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Choose your character"));

        JLabel nameLabel = new JLabel("Name: ");
        final JLabel typeLabel = new JLabel("Type: ");

        final JTextField nameField = new JTextField(10);
        final JComboBox<String> types = new JComboBox();

        types.addItem("Sorcerer");
        types.addItem("Monk");
        types.addItem("Scout");

        JButton addBtn = new JButton("Add");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String type = types.getSelectedItem().toString();

                String text = name + ": " + type + "\n";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        types.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text;
                switch (types.getSelectedItem().toString().toLowerCase()) {
                    case "sorcerer":
                        text = "Sorcerer:\n hp: 10\natk: 20 \ndef:12\n";
                        fireDetailEvent(new DetailEvent(this, text));
                        break;
                    case "monk":
                        text = "Monk:\n hp: 10\natk: 20 \ndef:12\n";
                        fireDetailEvent(new DetailEvent(this, text));
                        break;
                    case "scout":
                        text = "Scout:\n hp: 10\natk: 20 \ndef:12\n";
                        fireDetailEvent(new DetailEvent(this, text));
                        break;
                }
            }
        });

        //set layout
        setLayout(new GridBagLayout()); //;ets you add controls with gridbag constraints

        GridBagConstraints gc = new GridBagConstraints();

        //// First Column ////////////////

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(nameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(typeLabel, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(types, gc);

        //FINAL ROW
        gc.weighty = 10;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(addBtn, gc);
    }

    public void fireDetailEvent(DetailEvent event){
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2){
            if(listeners[i] == DetailListener.class){
                ((DetailListener)listeners[i+1]).detailEventOccurred(event);
            }
        }
    }

    public void addDetailListener(DetailListener listener){
        listenerList.add(DetailListener.class, listener);

    }
    public void removeDetailListener(DetailListener listener){
        listenerList.remove(DetailListener.class, listener);

    }
}
