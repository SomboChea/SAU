package smlogx.api.v1.IO;

import smlogx.api.v1.Interfaces.IO.IWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Writer implements IWriter {
    private File file = null;
    private String filename = "log.txt";

    private boolean conFile() {
        try {
            file = new File(this.filename);
            return true;
        } catch (Exception io) { return false; }
    }

    public Writer() {
        conFile();
    }

    public Writer(String filename) {
        this.filename = filename;
        conFile();
    }

    public boolean createDir(String path) {
        try {
            return file.mkdirs();
        } catch (Exception io) { return false; }
    }

    public boolean createFile() {
        try {
            return file.createNewFile();
        } catch (Exception io) { return false; }
    }

    public boolean setText(String text) {
        try {
            Files.write(Paths.get(this.filename), text.getBytes(), StandardOpenOption.WRITE);
            return true;
        } catch (IOException io) { return false; }
    }

    public boolean appendText(String text) {
        try {
            Files.write(Paths.get(this.filename),text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException io) { return false; }

    }

    public boolean appendLine(String text) {
        try {
            Files.write(Paths.get(this.filename), ("\n"+text).getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException io) {return false;}
    }

    public boolean removeFile() {
        try {
            return file.delete();
        } catch (Exception io) { return false; }
    }

    public boolean removeText() {
        try {
            Files.write(Paths.get(this.filename), "".getBytes(), StandardOpenOption.WRITE);
            return true;
        } catch (IOException io) {return false;}
    }

    public boolean removeLine(int line) {
        return false;
    }

    public boolean appendOnLine(int line, String text) {
        return false;
    }

}
