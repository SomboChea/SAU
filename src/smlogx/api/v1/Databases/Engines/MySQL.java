package smlogx.api.v1.Databases.Engines;

import smlogx.api.v1.Configuration.Prefs.Config;
import smlogx.api.v1.Configuration.Database.DBNode;
import smlogx.api.v1.Interfaces.Database.IBaseDatabase;
import smlogx.api.v1.Logging.Log;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import static smlogx.api.v1.Databases.DB.GetConnection;

public class MySQL extends DBAction implements IBaseDatabase.DML {

    @Override
    public boolean Open() {
        try {
            Config config = new Config(DBNode.DB_ROOT);
            String url = config.Read("hostname") + "/" + config.Read("dbname");
            GetConnection = DriverManager.getConnection(url,config.Read("username"),config.Read("password"));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            Log.Write(e.getMessage(), "MySQL.Open");
        }
        return false;
    }

    @Override
    public boolean Insert(String table, String cols, String data) {
        return false;
    }

    @Override
    public boolean Insert(String table, HashMap<String, Object> data) {
        return false;
    }

    @Override
    public boolean Update(String table, String cols, String data, Object whereIs) {
        return false;
    }

    @Override
    public boolean Update(String table, HashMap<String, Object> data, Object whereIs) {
        return false;
    }

    @Override
    public boolean Delete(String table, Object whereIs) {
        return false;
    }


}
