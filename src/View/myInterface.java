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
public class myInterface extends JFrame {

    public myInterface(){

        try{
            initialize();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void initialize() throws Exception{
        this.setSize(660, 430);
        this.setTitle("Statistical Analysis");

        String[] columnNames = {"Первый столбец", "Второй столбец", "Третий столбец"};
        //Массив ячеек таблицы
        Object[] [] dataTable = {
                {"Первый столбец строка 1", "Второй столбец строка 1", "Третий столбец строка 1"},
                {"Первый столбец строка 2", "Второй столбец строка 2", "Третий столбец строка 2"},
                {"Первый столбец строка 3", "Второй столбец строка 3", "Третий столбец строка 3"},
                {"Первый столбец строка 4", "Второй столбец строка 4", "Третий столбец строка 4"},
                {"Первый столбец строка 5", "Второй столбец строка 5", "Третий столбец строка 5"},
                {"Первый столбец строка 6", "Второй столбец строка 6", "Третий столбец строка 6"},
                {"Первый столбец строка 7", "Второй столбец строка 7", "Третий столбец строка 7"},
                {"Первый столбец строка 8", "Второй столбец строка 8", "Третий столбец строка 8"},
        };

        JTable jTable = new JTable(dataTable, columnNames);

        JPanel jPanel = new JPanel();

        jPanel.add(jTable);
        this.getContentPane().add(jPanel);
    }
}
