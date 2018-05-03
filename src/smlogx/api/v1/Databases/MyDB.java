package smlogx.api.v1.Databases;

import smlogx.api.v1.Databases.Engines.DBAction;
import smlogx.api.v1.Interfaces.Database.IBaseDatabase;

import java.sql.SQLException;
import java.util.HashMap;

public class MyDB extends DBAction implements IBaseDatabase.DML {

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

    @Override
    public boolean Open() throws SQLException {
        return false;
    }
}
