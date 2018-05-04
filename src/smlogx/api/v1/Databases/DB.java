package smlogx.api.v1.Databases;

import smlogx.api.v1.Databases.Engines.DBAction;
import smlogx.api.v1.Databases.Queries.Queries;
import smlogx.api.v1.Logging.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB extends DBAction {

    public static Connection Connection() {
        return DBAction.GetConnection();
    }

    public static boolean Exec(String sql) {
        try {
            Statement stmt = Connection().createStatement();
            return CheckQuery(stmt, sql);
        } catch (SQLException e) {
            Log.Write(e.getMessage(), "Queries.Exec");
        }
        return false;
    }

    public static boolean Select(String query) {
        return Exec(query);
    }

    protected static boolean CheckQuery(Statement stmt, String qry) {
        boolean a = false;
        try {
            a = stmt.execute(qry);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Log.Write(e.getMessage(), "DB.CheckQuery");
        }
        return a;
    }

    protected static ResultSet CheckResultSet(Statement stmt, String qry) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(qry);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Log.Write(e.getMessage(), "DB.CheckResultSet");
        }
        return rs;
    }

    @Override
    public boolean Open() {
        return super.Open();
    }
}
