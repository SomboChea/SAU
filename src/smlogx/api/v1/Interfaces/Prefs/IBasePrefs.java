package smlogx.api.v1.Interfaces.Prefs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public interface IBasePrefs {

    void Write(String key, Object value);
    String Read(String key);
    Boolean ReadBoolean(String key);
    Double ReadDouble(String key);
    Integer ReadInt(String key);
    void Delete(String key);
    boolean KeyExists(String key);
    int Count() throws BackingStoreException;
    boolean NodeExists(String node) throws BackingStoreException;
    void RemoveNode() throws BackingStoreException;
    void ExportNode(OutputStream os) throws IOException, BackingStoreException;
    Preferences Node(String node);
    boolean IsUserNode();

}
