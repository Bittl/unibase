package repares;

import DBConnect.DBConnect;

import javax.swing.table.AbstractTableModel;

public class ReparesTableModel extends AbstractTableModel {

    static Object[][] data;
    static{
        DBConnect.connect("UniBase.db");
    }


    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
