package smlogx.api.v1.Configuration.Prefs;

import smlogx.api.v1.Interfaces.Prefs.IBasePrefs;

import java.util.prefs.Preferences;

public class Config implements IBasePrefs{
    private static Preferences prefs;

    public Config() {
        prefs = Preferences.userNodeForPackage(Node.class);
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

}
