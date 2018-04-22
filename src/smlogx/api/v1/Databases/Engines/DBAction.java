package smlogx.api.v1.Databases.Engines;

import smlogx.api.v1.Interfaces.Database.IBaseDatabase;

public abstract class DBAction implements IBaseDatabase.IDBAction {
    @Override
    public abstract boolean Open();

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

        return false;
    }
}
