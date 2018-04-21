package API.v1.String;

import java.util.ArrayList;

public class MString {

    public static String implode(ArrayList<String> data, CharSequence separator) {

        return String.join(separator,data);
    }

    public static String[] explode(String data, String splitter) {

        return data.split(splitter);
    }

    public static String concat(String[] data) {
        String ext = "";
        for (String a:data
                ) {
            ext += a;
        }
        return ext;
    }

}
