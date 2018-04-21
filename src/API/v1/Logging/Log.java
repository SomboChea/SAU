package API.v1.Logging;

import API.v1.IO.Reader;
import API.v1.IO.Writer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public static void Write(String log, String logFrom) {
        Date date = new Date();
        SimpleDateFormat fdate = new SimpleDateFormat("E dd-MM-yyyy hh:mm:ss a");
        Writer w = new Writer();

        w.createFile();
        w.appendLine("[ " + fdate.format(date) + " ] || FROM => " + logFrom + " <=  || LOG@ => " +log + " <= ");
    }

    public static String Read(String pathRef) {

        Reader r = new Reader();

        return r.getText();
    }
}
