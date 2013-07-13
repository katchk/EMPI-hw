package Logic;

import org.jfree.data.category.DefaultCategoryDataset;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: katch
 * Date: 12.07.13
 * Time: 8:51
 * To change this template use File | Settings | File Templates.
 */
public class GraphConception {

    public static DefaultCategoryDataset CalculateAxisData(double[] array){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<String> columnKey = new ArrayList<String>();
        double max = max(array);
        double step = getStep(array);
        int[] value = new int[(int)(max / step +1)];

        double v =0;
        for (int i = 0; i < array.length; i++){
            v+= step;
            columnKey.add(String.valueOf(Math.round(v)));
        }

        int k = 0;
        for (double i = 0; i < max; i += step)
        {
            int sum = 0;

            for (int n = 0; n < array.length; n++)
            {
                if (array[n] != -1)
                {
                    if (array[n] > i && array[n] < i + step)// "sum" частота попадания в карман
                    {
                        sum++;
                    }
                }
            }
            value[k] = sum;
            k++;
        }

        for(int i = 0; i < value.length; i++){
            dataset.setValue((double)value[i], "Marks", columnKey.get(i));
        }

        return dataset;
    }

    private static double getStep(double[] array){
        double max = max(array);
        double min = min(array);
        double length = array.length;

        return (max - min) / Math.sqrt(length);
    }

    private static double max(double[] values) {
        double max = Double.MIN_VALUE;
        for(double value : values) {
            if(value > max)
                max = value;
        }
        return max;
    }

    private static double min(double[] values) {
        double min = Double.MAX_VALUE;
        for(double value : values) {
            if(value < min)
                min = value;
        }
        return min;
    }
}
