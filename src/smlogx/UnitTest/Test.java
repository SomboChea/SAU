package smlogx.UnitTest;

import smlogx.api.v1.Configuration.Prefs.Config;
import smlogx.api.v1.Configuration.Database.DBNode;
import smlogx.api.v1.Databases.Engines.Model;

import java.util.prefs.BackingStoreException;

public class Test {

    public void test() {
        System.out.println("From Unit.Test.test()");
    }

    public static void main(String[] args) throws BackingStoreException {

        Config config = new Config(DBNode.DB_ROOT);

//        config.Write("driver", "postgres");
//       config.Write("host", "172.17.0.3");
//        config.Delete("host");
//        config.Write("port",1433);
//        config.Delete("port");
//       config.Write("dbname", "postgres");
//        config.Write("username", "postgres");
//       config.Write("password", "postgres");


        Model d = new Model();

        System.out.println("");


    }
}
