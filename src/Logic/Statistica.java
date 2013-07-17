package Logic;

import java.util.*;

public class Statistica {


    public static double Expectation(double[] array)
    {
        double summa = 0;
        int size = array.length;

        for (int i = 0; i < array.length; ++i)
        {
            if(array[i] != -1) summa += array[i];
            else --size;
        }

        return summa / size;
    }

    public static double Variance(double[] array, double expectation)
    {
        double summa = 0;
        int size = array.length;

        for (int i = 0; i < array.length; ++i)
        {
            if(array[i] != -1) summa += Math.pow(expectation - array[i], 2);
            else --size;
        }

        return summa / size;
    }

    public static double Deviation(double[] array, double expectation)
    {
        double summa = 0;
        int size = array.length;

        for (int i = 0; i < array.length; ++i)
        {
            if(array[i] != -1) summa += Math.pow(expectation - array[i], 2);
            else --size;
        }


        summa /= (size - 1);

        return Math.sqrt(summa);
    }

    public static double Deviation(double variance)
    {
        return Math.sqrt(variance);
    }

    public static double Asymmetry(double[] array,
                                   double expectation, double deviation)
    {
        double summa = 0;
        int size = array.length;

        for (int i = 0; i < array.length; ++i)
        {
            if (array[i] != -1) summa += Math.pow((array[i] - expectation) / deviation, 3);
            else --size;
        }


        double n1 = size - 1;
        double n2 = size - 2;
        double n3 = n1 * n2;
        double n = size / n3;

        return summa * n;
    }

    public static double Kurtosis(double[] array, double expectation,
                                  double deviation)
    {

        double size = array.length;

        double summa = 0;

        for (int i = 0; i < array.length; ++i)
        {
            if (array[i] != -1) summa += Math.pow((array[i] - expectation) / deviation, 4);
            else --size;
        }

        double x1 = (size * (size + 1)) / ((size - 1) * (size - 2) * (size - 3));
        double x2 = (3 * Math.pow(size - 1, 2)) / ((size - 2) * (size - 3));

        return (x1 * summa) - x2;
    }

    public static double Correl(double[] x, double[] y,
                                double expectationX, double expectationY)
    {
        if (x.length == y.length)
        {
            double summa1 = 0;
            double summa2 = 0;
            double summa3 = 0;

            for (int i = 0; i < x.length; ++i)
            {
                summa1 += (x[i] - expectationX) * (y[i] - expectationY);

                summa2 += Math.pow(x[i] - expectationX, 2);
                summa3 += Math.pow(y[i] - expectationY, 2);
            }

            summa1 /= Math.sqrt(summa2 * summa3);

            return summa1;
        }
        else
        {
            return 0;
        }
    }

    public static double Correl(double[] x, double[] y) //спирмана
    {
        int[] rX = RangArray(x);
        int[] rY = RangArray(y);
        double[] sqrD = SqrD(rX, rY);

        int m = sqrD.length;
        double opper1 = m * (Math.pow(m, 2) - 1);
        double sum = 0;

        for (int i = 0; i < sqrD.length; ++i)
        {
            sum += sqrD[i];
        }

        return 1 - (6 * sum) / opper1;
    }

    private static int[] RangArray(double[] array)
    {
        ArrayList<Double> sortedArray = new ArrayList<Double>(array.length);
        for(int i = 0; i<array.length; i++){
            sortedArray.add(array[i]);
        }
        java.util.Collections.sort(sortedArray);

        int[] rangArray = new int[array.length];

        for (int i = 0; i < rangArray.length; ++i)
        {
            rangArray[i] = sortedArray.indexOf(array[i]) + 1;
        }

        return rangArray;

    }

    private static double[] SqrD(int[] rX, int[] rY)
    {
        double[] rangArray = new double[rX.length];

        for (int i = 0; i < rX.length; ++i)
        {
            rangArray[i] = Math.pow(rX[i] - rY[i], 2);
        }

        return rangArray;
    }
}
