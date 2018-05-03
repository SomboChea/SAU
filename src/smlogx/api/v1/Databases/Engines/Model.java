package smlogx.api.v1.Databases.Engines;

import smlogx.api.v1.Configuration.Prefs.Config;
import smlogx.api.v1.Configuration.Database.DBNode;
import smlogx.api.v1.Databases.DB;
import smlogx.api.v1.Interfaces.Database.IModel;
import smlogx.api.v1.Logging.Log;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Model extends DBAction implements IModel {

    @Override
    public boolean Open() {
        String url;
        String driver_type = "thin";
        try {

            Config config = new Config(DBNode.DB_ROOT);
            DBNode.DRIVER = DBNode.CheckDriver(config);
            String port = ":" + DBNode.CheckPort(config);
            driver_type = config.Read("driver_type") == null ? driver_type : config.Read("driver_type");

            switch (DBNode.DRIVER) {
                case MySQL:
                    //Class.forName(DBNode.MYSQL_DRIVER);
                    url =   DBNode.JDBC_ROOT +
                            DBNode.MYSQL_DRIVER_URI +
                            "://" + config.Read("host") +
                            port +
                            "/" + config.Read("dbname");
                    DB.GetConnection = DriverManager.getConnection(url, config.Read("username"), config.Read("password"));
                    break;
                case MariaDB:
                    //Class.forName(DBNode.MARIADB_DRIVER);
                    url =   DBNode.JDBC_ROOT +
                            DBNode.MARIADB_DRIVER_URI +
                            "://" + config.Read("host") +
                            port +
                            "/" + config.Read("dbname");
                    DB.GetConnection = DriverManager.getConnection(url, config.Read("username"), config.Read("password"));
                    break;
                case SQLServer:
                    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    url =   DBNode.JDBC_ROOT +
                            DBNode.SQLSERVER_DRIVER_URI +
                            "://" + config.Read("host") +
                            port +
                            ";databaseName=" + config.Read("dbname") +
                            ";user=" + config.Read("username") +
                            ";password=" + config.Read("password");
                    DB.GetConnection = DriverManager.getConnection(url);
                    break;
                case Oracle:
                    //Class.forName(DBNode.ORACLE_DRIVER);
                    url =   DBNode.JDBC_ROOT +
                            DBNode.ORACLE_DRIVER_URI +
                            ":" + driver_type + ":" + config.Read("username") + config.Read("password") +
                            "@" + config.Read("host") + port; //TODO
                    DB.GetConnection = DriverManager.getConnection(url);
                    break;
                case Postgres:
                    url =   DBNode.JDBC_ROOT +
                            DBNode.POSTGRES_DRIVER_URI +
                            "://" + config.Read("host") +
                            port +
                            "/" + config.Read("dbname");
                    DB.GetConnection = DriverManager.getConnection(url, config.Read("username"), config.Read("password"));
                    break;
                default:
                    Log.Write("No Driver found!", "Model.Open.DBode.Driver");
                    return false;
            }

            return true;

        } catch (SQLException e) {
            Log.Write(e.getMessage(), "Model.Open");
        }
        return false;
    }

    @Override
    public void save() {

    }



}
