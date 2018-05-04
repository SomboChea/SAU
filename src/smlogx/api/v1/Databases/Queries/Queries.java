package smlogx.api.v1.Databases.Queries;

import smlogx.api.v1.Databases.DB;
import smlogx.api.v1.Interfaces.Database.IBaseDatabase;
import smlogx.api.v1.Logging.Log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Queries extends DB implements IBaseDatabase.IQueries {

    @Override
    public boolean Execute(String sql) {
        return super.Exec(sql);
    }

    @Override
    public Object Query(String sql) {
        return null;
    }

    @Override
    public ResultSet GetResultSet(String sql) {
        try {
            Statement stmt = GetConnection().createStatement();
            return CheckResultSet(stmt, sql);
        } catch (SQLException e) {
            Log.Write(e.getMessage(), "Queries.GetResultSet");
        }
        return null;
    }

    @Override
    public HashMap<String, Object> GetModel(String sql) {
        return null;
    }
}
