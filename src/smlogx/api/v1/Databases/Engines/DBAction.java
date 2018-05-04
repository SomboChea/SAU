package smlogx.api.v1.Databases.Engines;

import smlogx.api.v1.Configuration.Database.DBNode;
import smlogx.api.v1.Configuration.Prefs.Config;
import smlogx.api.v1.Databases.DB;
import smlogx.api.v1.Interfaces.Database.IBaseDatabase;
import smlogx.api.v1.Logging.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBAction implements IBaseDatabase.IDBAction {

    private static Connection _conn = null;

    protected static void SetConnection(Connection conn) {
        _conn = conn;
    }

    protected static Connection GetConnection() {
        return _conn;
    }

    @Override
    public boolean Open() {
        Connection connection;
        try {

            Config config = new Config(DBNode.DB_ROOT);
            DBNode.DRIVER = DBNode.CheckDriver(config);
            String port = ":" + DBNode.CheckPort(config);
            String url;

            switch (DBNode.DRIVER) {
                case MySQL:
                    //Class.forName(DBNode.MYSQL_DRIVER);
                    url =   DBNode.JDBC_ROOT +
                            DBNode.MYSQL_DRIVER_URI +
                            "://" + config.Read("host") +
                            port +
                            "/" + config.Read("dbname");
                    connection = DriverManager.getConnection(url, config.Read("username"), config.Read("password"));
                    break;
                case MariaDB:
                    //Class.forName(DBNode.MARIADB_DRIVER);
                    url =   DBNode.JDBC_ROOT +
                            DBNode.MARIADB_DRIVER_URI +
                            "://" + config.Read("host") +
                            port +
                            "/" + config.Read("dbname");
                    connection = DriverManager.getConnection(url, config.Read("username"), config.Read("password"));
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
                    connection = DriverManager.getConnection(url);
                    break;
                case Oracle:
                    //Class.forName(DBNode.ORACLE_DRIVER);
                    String driver_type = config.Read("driver_type") == null ? "thin" : config.Read("driver_type");
                    String service_type = config.Read("service_type") == null ? "xe" : config.Read("service_type");
                    url =   DBNode.JDBC_ROOT +
                            DBNode.ORACLE_DRIVER_URI +
                            ":" + driver_type + ":" + config.Read("username") + config.Read("password") +
                            "@" + config.Read("host") + port + ":" + service_type;
                    connection = DriverManager.getConnection(url, config.Read("username"), config.Read("password"));
                    break;
                case Postgres:
                    url =   DBNode.JDBC_ROOT +
                            DBNode.POSTGRES_DRIVER_URI +
                            "://" + config.Read("host") +
                            port +
                            "/" + config.Read("dbname");
                    connection = DriverManager.getConnection(url, config.Read("username"), config.Read("password"));
                    break;
                default:
                    Log.Write("No Driver found!", "Model.Open.DBode.Driver");
                    return false;
            }

            DB.SetConnection(connection);
            return true;

        } catch (SQLException e) {
            Log.Write(e.getMessage(), "Model.Open");
        }
        return false;
    }

    @Override
    public boolean Close() {
        try {
            _conn.close();
            return true;
        } catch (SQLException e){

        }
        return false;
    }
}
