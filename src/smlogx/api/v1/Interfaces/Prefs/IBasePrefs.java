package smlogx.api.v1.Interfaces.Prefs;

public interface IBasePrefs {

    void Write(String key, Object value);
    String Read(String key);
    Boolean ReadBoolean(String key);
    Double ReadDouble(String key);
    Integer ReadInt(String key);
    void Delete(String key);
    boolean KeyExists(String key);

}
