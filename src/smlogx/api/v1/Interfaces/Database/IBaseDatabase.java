package smlogx.api.v1.Interfaces.Database;

import java.sql.SQLException;
import java.util.HashMap;

public interface IBaseDatabase {

    interface IDBAction {
        boolean Open() throws SQLException;
        Object Query(String sql);
        Object GetModel(String table, String ext);
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
