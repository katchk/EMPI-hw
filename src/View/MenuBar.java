package View;

/**
 * Created with IntelliJ IDEA.
 * User: katch
 * Date: 08.07.13
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

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
