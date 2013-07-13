package Logic;

import javax.swing.*;
import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * User: katch
 * Date: 11.07.13
 * Time: 4:39
 * To change this template use File | Settings | File Templates.
 */
public class SupportFunction {
    private static double[] data;

    public static Object[][] getStaticData(JTable jTable, int numberOfColumn){
        double[] data = new double[jTable.getRowCount()+1];
        Object[][] ob = new Object[1][4];

        for (int i = 0; i < jTable.getRowCount(); i++){
            data[i] = Double.parseDouble(jTable.getValueAt(i, numberOfColumn).toString());
        }

        ArrayList<Double> staticData = new ArrayList<Double>();
        double expectation = Statistica.Expectation(data);
        double deviation = Statistica.Deviation(data, expectation);
        double variance = Statistica.Variance(data, expectation);
        double kurtosis = Statistica.Kurtosis(data, expectation, deviation);

        ob[0][0] = expectation;
        ob[0][1] = deviation;
        ob[0][2] = variance;
        ob[0][3] = kurtosis;

        return ob;
    }

    public static double[] getData(JTable jTable, int numberOfColumn){
        data = new double[jTable.getRowCount()+1];

        for (int i = 0; i < jTable.getRowCount(); i++){
            data[i] = new Double(jTable.getValueAt(i, numberOfColumn).toString());
        }
        return data;
    }
}
