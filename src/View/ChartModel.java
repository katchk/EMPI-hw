package View;

import Logic.GraphConception;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: katch
 * Date: 12.07.13
 * Time: 8:57
 * To change this template use File | Settings | File Templates.
 */
public class ChartModel {

    public static JFreeChart createBarChart(double array[]){
        JFreeChart chart = ChartFactory.createBarChart
                ("", "X", "Count", GraphConception.CalculateAxisData(array),
                        PlotOrientation.VERTICAL, false, true, false);

        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);

        return chart;
    }
}
