package smlogx.api.v1.Configuration.Prefs;

import smlogx.api.v1.Configuration.Database.DBNode;
import smlogx.api.v1.Interfaces.Prefs.IBasePrefs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Config implements IBasePrefs {
    private static Preferences prefs;

    public Config() {

        prefs = Preferences.userNodeForPackage(DBNode.class);
    }

    public Config(String userRoot) {

        prefs = Preferences.userRoot().node(userRoot);
    }

    @Override
    public void Write(String key, Object value) {

        prefs.put(key, value.toString());
    }

    @Override
    public String Read(String key) {

        return prefs.get(key, null);
    }

    @Override
    public Double ReadDouble(String key) {

        return Double.valueOf(prefs.get(key, null));
    }

    @Override
    public Integer ReadInt(String key) {

        return Integer.valueOf(prefs.get(key, null));
    }

    @Override
    public Boolean ReadBoolean(String key) {

        return Boolean.valueOf(prefs.get(key, null));
    }

    @Override
    public void Delete(String key) {

        prefs.remove(key);
    }


    @Override
    public boolean KeyExists(String key) {

        return prefs.get(key,null)!=null;
    }

    @Override
    public int Count() throws BackingStoreException {

        return prefs.keys().length;
    }

    @Override
    public boolean NodeExists(String node) throws BackingStoreException {

        return prefs.nodeExists(node);
    }

    @Override
    public void RemoveNode() throws BackingStoreException {

        prefs.removeNode();
    }

    @Override
    public void ExportNode(OutputStream os) throws IOException, BackingStoreException {

        prefs.exportNode(os);
    }

    @Override
    public Preferences Node(String node) {

        return prefs.node(node);
    }

    @Override
    public boolean IsUserNode() {

        return prefs.isUserNode();
    }
}
