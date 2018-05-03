package smlogx.UnitTest;

import smlogx.api.v1.Classes.Models.Students.Student;
import smlogx.api.v1.Configuration.Prefs.Config;
import smlogx.api.v1.Configuration.Database.DBNode;
import smlogx.api.v1.Databases.Engines.Model;
import smlogx.api.v1.String.MString;

import java.util.ArrayList;
import java.util.prefs.BackingStoreException;

public class Test {

    public void test() {
        System.out.println("From Unit.Test.test()");
    }

    public static void main(String[] args) throws BackingStoreException {

        Config config = new Config(DBNode.DB_ROOT);

        config.Write("driver", "mysql");
        config.Write("host", "localhost");
        config.Write("port", 3306);
        config.Write("dbname", "test");
        config.Write("username", "root");
        config.Write("password", "");


        Model d = new Model();

        //System.out.println(d.Open());
        //Config mycfg = new Config("mynode.config");

        //mycfg.Write("name", "Sambo");
        //mycfg.Write("dob", "02/07/96");
        //mycfg.Write("test","MyTstAAAA");
        //mycfg.Delete("test2");

//        System.out.println(mycfg.Read("name"));
//        System.out.println(mycfg.Read("dob"));
//        System.out.println(mycfg.Count());


        //String[] data = {"name", "age"};

        ArrayList<String> data = new ArrayList<>();
        data.add("name");
        data.add("age");

        String dd = "name,age";

        String res = MString.implode(data,":");

        String[] dat = MString.explode(res,":");

        System.out.println(dat[1]);

        Student std = new Student();
        std.name = "ss";
    }
}
