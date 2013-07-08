package View;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: katch
 * Date: 04.07.13
 * Time: 9:38
 * To change this template use File | Settings | File Templates.
 */
public class Interface {
    JMenuBar mainMenuBar;
    JTable mainTable;
    JTabbedPane grTabPane;
    JButton calcButton;
    JButton addRowBtn;
    JScrollPane jScrollPane;


    final Object[] headers = { "A", "B", "C" };

    Object[][] data = {
            { "", "", "" },
    };

    public Interface(){
        JFrame jFrame = new JFrame();
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
        grTabPane = new JTabbedPane();
        calcButton = new JButton("Calculating");
        addRowBtn = new JButton("Add Row");

        Dimension size = mainMenuBar.getPreferredSize();
        mainMenuBar.setBounds(insets.left, insets.top, size.width + 630, size.height + 5 );

        size = grTabPane.getPreferredSize();
        grTabPane.setBounds(1 + insets.left, 318 + insets.top, size.width+630, size.height + 250);

        size = calcButton.getPreferredSize();
        calcButton.setBounds(1 + insets.left, 282 + insets.top, size.width+40, size.height + 8);

        size = addRowBtn.getPreferredSize();
        addRowBtn.setBounds(300 + insets.left, 282 + insets.top, size.width+30, size.height + 8);

        addRowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.addRow(new Vector());
            }
        });

        jScrollPane = new JScrollPane(mainTable);

        size = jScrollPane.getPreferredSize();
        jScrollPane.setBounds(1 + insets.left, 28 + insets.top, size.width + 630, size.height + 250);
        jScrollPane.setSize(new Dimension(630, 250));


        jFrame.getContentPane().add(mainMenuBar);
        jFrame.getContentPane().add(grTabPane);
        jFrame.getContentPane().add(calcButton);
        jFrame.getContentPane().add(addRowBtn);
        jFrame.getContentPane().add(jScrollPane);
        jFrame.setVisible(true);


    }

    private JTable createMainTable(){
        final String[] colNames = {"1", "2", "3", "4", "5", "6"};

        mainTable = new JTable();
        TableModel DataModel = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return colNames.length;
            }

            @Override
            public int getColumnCount() {
                return colNames.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return null;
            }

            @Override
            public String getColumnName(int column) {return colNames[column];}

            @Override
            public Class getColumnClass(int c) {return (String.class);}
        };
        mainTable.setModel(DataModel);

        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        return mainTable;
    }
}
