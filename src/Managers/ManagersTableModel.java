package Managers;

import DBConnect.DBConnect;
import InsideSettings.EmploeersSettings;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

/**
 * Created by ПКПК on 10.07.2017.
 */
public class ManagersTableModel extends AbstractTableModel {

    static Object[][] data;

    static{
        DBConnect.connect("UniBase.db");

    }

    // Конструктор, делаем массив данных Для заполнения таблицы Если таблицы нет, то создаём её и извлекаем этот массив
    public ManagersTableModel()  {


        try{
            data = DBConnect.read(EmploeersSettings.TABLE_NAME);
        } catch (SQLException e){

            String request = "create table " + EmploeersSettings.TABLE_NAME + " " + "(id integer NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                    " second_name text not null, " +
                    " first_name text not null, " +
                    " third_name text, " +
                    " email text, " +
                    " phone text, " +
                    " password text, " +
                    " privacy integer not null )";
            DBConnect.create(request);
            try {
                data = DBConnect.read(EmploeersSettings.TABLE_NAME);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }


    }

    //количество строчек в таблице, вычисляем по количеству массивов в массиве data
    @Override
    public int getRowCount() {
        return data.length;
    }

    //количество колонок вычисляем из известного нам массива
    @Override
    public int getColumnCount() {
        return EmploeersSettings.columnnames.size();
    }


    // достаём значение из массива данных
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    //раздаём имена столбцов (колонок)
    @Override
    public String getColumnName(int column) {
        return EmploeersSettings.columnnames.get(column);
    }

    //запрет на редактирование ячеек, при этом можно получать их координаты
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    // добавление в БД записи из массива data
    public static void addToBase(String[] data){
        String reqest = "insert into " + EmploeersSettings.TABLE_NAME + " (second_name, first_name, third_name, email, phone, password, privacy) values (";
        for (int i = 0; i < data.length; i++) {
            if (i != data.length - 1) reqest += "'" + data[i] + "', ";
            else reqest += "'" + Integer.parseInt(data[i]) + "')";
        }
        reqest +=";";
        System.out.println(reqest);

        DBConnect.write(reqest);
    }

    // находим ID для манипуляций со сторкой с этим ID
    public static int getId(int row){
        try{
            data = DBConnect.read(EmploeersSettings.TABLE_NAME);
        } catch (SQLException e) {
            System.out.println("No Base");
        }
        return Integer.parseInt(data[row][0].toString());
    }

    // удаляем по ID
    public static void deleteFromBase(int id){
        String request = "delete from " + EmploeersSettings.TABLE_NAME + " where ID = "  + id ;
        DBConnect.write(request);
    }

    // вычленяем массив строчек по ID
    public static String[] getFromBase (int id){

        String[] data =  DBConnect.getRow(id, EmploeersSettings.TABLE_NAME);

        return data;
    }
    public static void changeInBase(String[] data, int id){

        String reqest = "update " + EmploeersSettings.TABLE_NAME + " set ";
        for (int i = 0; i < data.length; i++) {
            if (i != data.length - 1) reqest += EmploeersSettings.tableNames[i] + " = '" + data[i] + "', ";
            else reqest += EmploeersSettings.tableNames[i] + " = '" + Integer.parseInt(data[i]) + "'";
        }
        reqest +=" where ID = " + id;
        System.out.println(reqest);

        DBConnect.write(reqest);

        //(second_name, first_name, third_name, email, phone, password, privacy) values (
    }
}
