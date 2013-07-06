package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: katch
 * Date: 04.07.13
 * Time: 9:38
 * To change this template use File | Settings | File Templates.
 */
public class Interface extends JFrame{
    JMenuBar MainMenuBar;
    JTable MainTable;
    JTabbedPane GrTabPane;
    JButton CalcButton;

    public Interface(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultLookAndFeelDecorated(true);
        Insets insets = this.getInsets();
        this.setSize(632 + insets.left + insets.right,
                615 + insets.top + insets.bottom);
        this.setTitle("Statistical Analysis");
        this.setLayout(null);
        MainMenuBar = new JMenuBar();
        MainTable = new JTable();
        GrTabPane = new JTabbedPane();
        CalcButton = new JButton("Calculating");

        this.add(MainMenuBar);
        this.add(MainTable);
        this.add(GrTabPane);
        this.add(CalcButton);


        Dimension size = MainMenuBar.getPreferredSize();
        MainMenuBar.setBounds(insets.left, insets.top, size.width + 630, size.height + 25 );

        size = MainTable.getPreferredSize();
        MainTable.setBounds(1 + insets.left, 28 + insets.top, size.width + 630, size.height + 250);

        size = GrTabPane.getPreferredSize();
        GrTabPane.setBounds(1 + insets.left, 318 + insets.top, size.width+630, size.height + 250);

        size = CalcButton.getPreferredSize();
        CalcButton.setBounds(1 + insets.left, 282 + insets.top, size.width+40, size.height + 8);


    }
}
