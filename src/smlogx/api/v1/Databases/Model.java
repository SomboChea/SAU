package smlogx.api.v1.Databases;

import smlogx.api.v1.Configuration.Prefs.Config;
import smlogx.api.v1.Configuration.Database.DBNode;
import smlogx.api.v1.Databases.Engines.DBAction;
import smlogx.api.v1.Interfaces.Database.IModel;
import smlogx.api.v1.Logging.Log;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Model extends DBAction implements IModel {

    protected String table = null;

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }


}
