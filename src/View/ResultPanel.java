package View;

import Logic.SupportFunction;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: katch
 * Date: 10.07.13
 * Time: 2:27
 * To change this template use File | Settings | File Templates.
 */
public class ResultPanel extends JFrame {
    Object[] headers = { "Expectation", "Deviation", "Variance", "Kurtosis" };
    public ResultPanel(JTable jTable){
        this.setLayout(new FlowLayout());
        this.setSize(700, 600);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setSize(500, 400);
        JPanel jPanel;
        JTable resultTable;
        JScrollPane jScrollPane;

        int tabCount = jTable.getColumnCount();

        for(int i = 0; i < tabCount;  i++){
            double[] data = SupportFunction.getData(jTable, i);
            resultTable = new JTable(new DefaultTableModel(SupportFunction.getStaticData(jTable, i), headers));
            resultTable.setSize(300, 50);
            resultTable.setPreferredScrollableViewportSize(new Dimension(250, 50));
            jPanel = new JPanel(new BorderLayout());
            jScrollPane = new JScrollPane(resultTable);
            jScrollPane.setSize(301, 51);

            ChartPanel CP = new ChartPanel(ChartModel.createBarChart(data));

            jPanel.add(CP, BorderLayout.NORTH);
            jPanel.add(jScrollPane, BorderLayout.SOUTH);

            jTabbedPane.addTab(jTable.getColumnName(i), jPanel);
        }

        this.getContentPane().add(jTabbedPane);

    }

}
