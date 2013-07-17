package View;

import Logic.GraphConception;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import java.awt.*;


public class ChartModel {

    public static JFreeChart createBarChart(double data[]){
        JFreeChart chart = ChartFactory.createBarChart
                ("", "X", "Count", GraphConception.CalculateAxisData(data),
                        PlotOrientation.VERTICAL, false, true, false);

        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);

        return chart;
    }
}
