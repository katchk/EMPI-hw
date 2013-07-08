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
    Vector<String> columnNames = new Vector<String>();
    public TableModel(){
        this.setRowCount(30);
        this.setColumnCount(10);
    }
}
