package View;

import Logic.SupportFunction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class Interface {
    JMenuBar mainMenuBar;
    static JTable mainTable;
    JButton calcButton;
    JButton addRowBtn;
    JScrollPane jScrollPane;

    public Interface(){
        final JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setDefaultLookAndFeelDecorated(true);
        jFrame.setResizable(false);
        Insets insets = jFrame.getInsets();
        jFrame.setSize(634 + insets.left + insets.right,
                615 + insets.top + insets.bottom);
        jFrame.setTitle("Statistical Analysis");
        jFrame.getContentPane().setLayout(null);
        MenuBar mb = new MenuBar();
        mainMenuBar = mb.createMenuBar();
        final View.TableModel tableModel = new View.TableModel();
        mainTable = new JTable(tableModel);
        calcButton = new JButton("Calculating");
        addRowBtn = new JButton("Add Row");

        Dimension size = mainMenuBar.getPreferredSize();
        mainMenuBar.setBounds(insets.left, insets.top, size.width + 630, size.height + 5 );

        size = calcButton.getPreferredSize();
        calcButton.setBounds(1 + insets.left, 458 + insets.top, size.width+40, size.height + 8);
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < mainTable.getColumnCount(); i++){
                    SupportFunction.SearchForDeviation(mainTable, i);
                }
                new ResultPanel(mainTable).setVisible(true);
            }
        });

        size = addRowBtn.getPreferredSize();
        addRowBtn.setBounds(140 + insets.left, 458 + insets.top, size.width+30, size.height + 8);
        addRowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.addRow(new Vector());
            }
        });

        jScrollPane = new JScrollPane(mainTable);

        size = jScrollPane.getPreferredSize();
        jScrollPane.setBounds(1 + insets.left, 28 + insets.top, size.width + 630, size.height + 425);
        jScrollPane.setSize(new Dimension(630, 425));

        jFrame.getContentPane().add(mainMenuBar);
        jFrame.getContentPane().add(calcButton);
        jFrame.getContentPane().add(addRowBtn);
        jFrame.getContentPane().add(jScrollPane);
        jFrame.setVisible(true);
    }

}
