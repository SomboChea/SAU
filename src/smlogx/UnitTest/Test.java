package smlogx.UnitTest;

import smlogx.api.v1.Databases.Queries.Queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.prefs.BackingStoreException;

public class Test {

    public void test() {
        System.out.println("From Unit.Test.test()");
    }

    public static void main(String[] args) throws BackingStoreException {

        Queries q = new Queries();



        //Singleton qq = Queries();

//        Config config = new Config(DBNode.DB_ROOT);
//
//        config.Write("driver", "mysql");
//        config.Write("host", "localhost");
//        config.Write("port", 3306);
//        config.Write("dbname", "test");
//        config.Write("username", "root");
//        config.Write("password", "");
//
//
//        Model d = new Model();

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

//        ArrayList<String> data = new ArrayList<>();
//        data.add("name");
//        data.add("age");
//
//        String dd = "name,age";
//
//        String res = MString.implode(data,":");
//
//        String[] dat = MString.explode(res,":");
//
//        System.out.println(dat[1]);
//
//        Student std = new Student();
//        std.name = "ss";

//        ArrayList<HashMap> list = new ArrayList<>();
//
//        HashMap<String, Object> m = new HashMap<>();
//        m.put("a",1);
//        m.put("b",2);
//
//        list.add(m);
//
//        HashMap<String, Object> m2 = new HashMap<>();
//        m.put("a",3);
//        m.put("b",4);
//
//        list.add(m2);
//
//        System.out.println(list);

    }
}
