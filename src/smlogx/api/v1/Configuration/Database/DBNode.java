package smlogx.api.v1.Configuration.Database;

import smlogx.api.v1.Configuration.Prefs.Config;
import smlogx.api.v1.Databases.Engine;

public class DBNode {
    private String _node;
    public DBNode() {
        this._node = "DBNode of Config...";
    }
    public String getNode() {
        return this._node;
    }

    public final static String DB_ROOT = "smx.db.config";
    public static final String JDBC_ROOT = "jdbc:";
    public final static String MYSQL_DRIVER = "com.mysql.jdboc.driver";
    public final static String MYSQL_DRIVER_URI = "mysql";
    public static final String MARIADB_DRIVER = "org.mariadb.jdbc.Driver";
    public static final String MARIADB_DRIVER_URI = "mariadb";
    public static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String SQLSERVER_DRIVER_URI = "sqlserver";
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String ORACLE_DRIVER_URI = "oracle";
    public static final String POSTGRES_DRIVER_URI = "postgresql";
    //public static final String POSTGRES_DRIVER_URI = "";

    public static Engine DRIVER = Engine.MySQL;

    public static Engine CheckDriver(Config cfg) {
        switch (cfg.Read("driver")) {
            case "mysql":
                return Engine.MySQL;
            case "mariadb":
                return Engine.MariaDB;
            case "sqlsrv":
            case "sqlserver":
                return Engine.SQLServer;
            case "oracle":
                return Engine.Oracle;
            case "postgres":
            case "postgresql":
                return Engine.Postgres;
            default:
                return Engine.MySQL;
        }
    }

    public static String CheckPort(Config cfg) {
        String _port = "";
        switch (CheckDriver(cfg)) {
            case MySQL:
                _port = "3306";
                break;
            case MariaDB:
                _port = "3306";
                break;
            case SQLServer:
                _port = "1433";
                break;
            case Oracle:
                _port = "1521";
                break;
            case Postgres:
                _port = "5432";
                break;

        }
        return cfg.Read("port")==null?_port:cfg.Read("port");
    }

}
