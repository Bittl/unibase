package DBConnect;

import java.sql.*;

/**
 * Created by ПКПК on 04.07.2017.
 */
public class DBConnect {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String reqest;
    //    static int countRows;
    private static String[] columnNames = null;
    private static int countColls;
    private static int countRows;

    // Конструктор, создающий соединение с базой данных, на вход принимает адрес базы


    public DBConnect(String address){
        String connectAddress = "jdbc:sqlite:" + address;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(connectAddress);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //то же что и конструктор, но только метод :)))

    public static void connect(String address){
        String connectAddress = "jdbc:sqlite:" + address;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(connectAddress);
            statement = connection.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Создание новой таблицы или БД Если её вдруг нету

    public static void create(String create){

        try {
            statement.execute(create);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void write(String reqest){
        try {
            statement.execute(reqest);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String[][] read(String tableName) throws SQLException {

        String sql = "SELECT * FROM " + tableName; // запрос, который запрашивает всё из таблицы tableName
//        int countColls; // количество столбцов

        int countRows; //количество строк
        String[][] data = null; // возвращаемый результат



        resultSet = statement.executeQuery(sql);
        countColls = resultSet.getMetaData().getColumnCount();
        columnNames = new String[countColls];
        countRows = 0;
        for (int i = 0; i < countColls; i++) {
            columnNames[i] = resultSet.getMetaData().getColumnName(i+1);
        }

        while (resultSet.next()){
            countRows ++;
        }
        resultSet.close();
        resultSet = statement.executeQuery(sql);

        data = new String[countRows][countColls];
        int a = 0;
        while (resultSet.next()){
            for (int i = 0; i < countColls; i++) {
                data[a][i] = resultSet.getString(columnNames[i]);
            }
            a++;
        }
        resultSet.close();



        return data;
    }

    public static void closeDB(){
        try {
//            resultSet.close();
            statement.close();
            connection.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int getColls(){
        return countColls;
    }

    public static int getRows(){
        return countRows;
    }
// Получаем имена всех столбцов таблицы

    public static String[] getNames(String tableName){          // имена столбцов в таблице как их воспринимает БД БД
//        String sql = "PRAGMA table_info(" + "\"" + tableName + "\") ";
        String sql = "SELECT * FROM " + tableName;
        String[] names = null;
        try {
            resultSet = statement.executeQuery(sql);
            names = new String[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < names.length; i++) {
                names[i] = resultSet.getMetaData().getColumnLabel(i + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return names;
    }

    public static String[] getRow(int id, String tableName){
        String sql = "select * from " + tableName + " where id=" +  id + ";";
        String[] rowData = null;
        try {
            resultSet = statement.executeQuery(sql);
            rowData = new String[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < rowData.length; i++) {
                rowData[i] = resultSet.getString(i + 1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowData;
    }







}
