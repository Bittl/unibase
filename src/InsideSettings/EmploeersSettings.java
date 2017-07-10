package InsideSettings;

import java.util.Vector;

/**
 * Created by ПКПК on 10.07.2017.
 */
public class EmploeersSettings {

    public static final int ADMIN = 1;
    public static final int DIRECTOR = 2;
    public static final int MANAGER_PLUS = 3;
    public static final int MANAGER = 4;
    public static final int TECHNIK_PLUS = 5;
    public static final int TECHNIK = 6;

    public static final int GUEST = 10;

    public static final String TABLE_NAME = "employeers";

    public static Vector<String> columnnames = new Vector<>(); // нахрен здесь вектор - не пойму. ну пусть живёт пока


    static{
        columnnames.add("Фамилия");
        columnnames.add("Имя");
        columnnames.add("Отчество");
        columnnames.add("Эл. почта");
        columnnames.add("Телефон");
        columnnames.add("Пароль");
        columnnames.add("Права");

    }

}
