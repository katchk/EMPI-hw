package View;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
/**
 * Created with IntelliJ IDEA.
 * User: katch
 * Date: 08.07.13
 * Time: 23:54
 * To change this template use File | Settings | File Templates.
 */
public class TableModel extends DefaultTableModel {
    private static String[] columnName = {"CYC", "LOC", "NOC", "FOUT", "NDD", "CM", "WOC", "FDP"};

    public TableModel(){
        this.setRowCount(25);
        for(int i = 0; i < columnName.length; i++){
        this.addColumn(columnName[i]);
        }
    }
}
