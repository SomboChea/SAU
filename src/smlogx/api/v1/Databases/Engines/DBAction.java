package smlogx.api.v1.Databases.Engines;

import smlogx.api.v1.Databases.DB;
import smlogx.api.v1.Interfaces.Database.IBaseDatabase;
import smlogx.api.v1.Logging.Log;

import java.sql.SQLException;

public abstract class DBAction implements IBaseDatabase.IDBAction {

    @Override
    public Object Query(String sql) {

        return null;
    }

    @Override
    public Object GetModel(String table, String ext) {

        return null;
    }

    @Override
    public boolean Close() {
        try {
            DB.GetConnection.close();
            return true;
        } catch (SQLException e){
            Log.Write(e.getMessage(), "DBAction.Close");
        }
        return false;
    }
}
