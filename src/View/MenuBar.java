package View;

import java.awt.event.*;
import javax.swing.*;

public class MenuBar extends JFrame {
    JMenuBar menuBar = new JMenuBar();

    JMenu menuFile = new JMenu("File");
    JMenu menuOptions = new JMenu("Options");
    JMenu menuAbout = new JMenu("About");

    JMenuItem item1 = new JMenuItem("Open file");
    JMenuItem item2 = new JMenuItem("Save as...");
    JMenuItem item3 = new JMenuItem("Exit");

    public  JMenuBar createMenuBar(){
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuFile.add(item1);
        menuFile.add(item2);
        menuFile.addSeparator();
        menuFile.add(item3);

        menuBar.add(menuFile);
        menuBar.add(menuOptions);
        menuBar.add(menuAbout);

        return  menuBar;
    }

}
