package za.co.wethinkcode.swingy;

import za.co.wethinkcode.swingy.view.Cli.CliView;
import za.co.wethinkcode.swingy.view.Gui.GuiView;
import za.co.wethinkcode.swingy.view.Gui.MainFrame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args){

//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//            String line = reader.readLine();
//            if (line != null) {
//                while ((line = reader.readLine()) != null) {
//                    Character character = CharacterFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
//                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
//                            Integer.parseInt(line.split(" ")[4]));
//                    flyableList.add(flyable);
//                }
//            }
//        }catch (IOException e){
//
//        }
        try {
        switch(args[0].toLowerCase())
        {
            case "console":
                CliView.run();
                break;
            case "gui":
                GuiView.run();
                break;
        }
        }catch(Exception e){
            System.out.println("There was an error in the program");
        }

//
//        SwingUtilities.invokeLater(new Runnable(){
//            public void run() {
//                JFrame jFrame = new MainFrame("HELLO WORLD");
//                jFrame.setSize(500, 400);
//                jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
//                jFrame.setVisible(true);
//            }
//        });


    }
}
