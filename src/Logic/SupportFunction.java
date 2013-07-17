package Logic;

import javax.swing.*;
import java.util.ArrayList;

public class SupportFunction {


    public static Object[][] getStaticData(JTable jTable, int numberOfColumn){
        double[] data = new double[jTable.getRowCount()];
        Object[][] ob = new Object[1][5];

        for (int i = 0; i < jTable.getRowCount(); ++i){
            if(jTable.getValueAt(i, numberOfColumn) != null &&
                    ToDouble(jTable.getValueAt(i, numberOfColumn)) != -1){
                data[i] = ToDouble(jTable.getValueAt(i, numberOfColumn));
            }
        }

        ArrayList<Double> staticData = new ArrayList<Double>();
        double expectation = Statistica.Expectation(data);
        double deviation = Statistica.Deviation(data, expectation);
        double variance = Statistica.Variance(data, expectation);
        double kurtosis = Statistica.Kurtosis(data, expectation, deviation);
        double asymmetry = Statistica.Asymmetry(data, expectation, deviation);

        ob[0][0] = expectation;
        ob[0][1] = deviation;
        ob[0][2] = variance;
        ob[0][3] = kurtosis;
        ob[0][4] = asymmetry;

        return ob;
    }

    public static double[] getData(JTable jTable, int numberOfColumn){
        double[] data = new double[jTable.getRowCount()];

        for (int i = 0; i < jTable.getRowCount(); ++i){
            if(jTable.getValueAt(i, numberOfColumn) != null){
                data[i] = ToDouble(jTable.getValueAt(i, numberOfColumn));
            }
        }

        return data;
    }

    public static void SearchForDeviation(JTable jTable, int column)
    {
        boolean flag = false;
        double[] metricsArray = getData(jTable, column);
        for (int i = 0; i < metricsArray.length; ++i)
        {
            if (metricsArray[i] != -1)
            {
                double expectation = Statistica.Expectation(metricsArray);
                double variance = Statistica.Variance(metricsArray, expectation);
                double deviation = Statistica.Deviation(variance);

                double value = Math.abs(metricsArray[i] - expectation) / deviation;

                if (value > 1.96)
                {
                    metricsArray[i] = -1;
                    jTable.setValueAt("-1", i, column);
                    flag = true;
                }
            }
            if (flag) SearchForDeviation(jTable, column);
        }
    }

    public static Double ToDouble(Object obj){
        return Double.parseDouble(obj.toString());
    }
}
