package View;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {
    private static String[] columnName = {"CYC", "LOC", "NOC", "FOUT"};          //, "LOC", "NOC", "FOUT", "NDD", "CM", "WOC", "FDP

    public TableModel(){
        this.setRowCount(25);
        for(int i = 0; i < columnName.length; i++){
        this.addColumn(columnName[i]);
        }
    }
}
