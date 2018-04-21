package API.v1.Interfaces.IO;

public interface IWriter {
    boolean createDir(String path);
    boolean createFile();
    boolean setText(String text);
    boolean appendText(String text);
    boolean appendLine(String text);
    boolean removeFile();
    boolean removeText();
    boolean removeLine(int line);
    boolean appendOnLine(int line, String text);
}