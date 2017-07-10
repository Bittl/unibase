package InsideSettings;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;


/**
 * Created by ПКПК on 10.07.2017.
 */
public class CreateLog {


    public static void addLog(String log){
        try (FileWriter writer = new FileWriter("logs.log", true)){

            Calendar date = Calendar.getInstance();
            String today = date.get(date.YEAR) + "." + date.get(date.MONTH) + "." + date.get(date.DAY_OF_MONTH) + " : " +
                    date.get(date.HOUR_OF_DAY) + "-" + date.get(date.MINUTE) + " - ";


            writer.write(today + log);
            writer.write("\n");

            writer.flush();
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }




    }
}
