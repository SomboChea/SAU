package smlogx.api.v1.Interfaces.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IBaseDatabase {

    interface IQueries {
        boolean Execute(String sql);
        Object Query(String sql);
        ResultSet GetResultSet(String sql);
        HashMap<String, Object> GetModel(String sql);
    }

    interface IDBAction {
        boolean Open() throws SQLException;
        boolean Close();
    }

    interface DML {
        boolean Insert(String table, String cols, String data);
        boolean Insert(String table, HashMap<String, Object> data);
        boolean Update(String table, String cols, String data, Object whereIs);
        boolean Update(String table, HashMap<String, Object> data, Object whereIs);
        boolean Delete(String table, Object whereIs);
    }

    interface DDL {
        boolean Create(String table, String properties);
        boolean Drop(String table);
        boolean Empty(String table);
        boolean Alter(String table, String alter_properties);
    }

    interface DCL {
        boolean Grant();
        boolean Revoke();
    }

    interface DTL {
        boolean Rollback();
        boolean Commit();
    }

    interface ADL {
        void StartAudit();
        void StopAudit();
    }
}
