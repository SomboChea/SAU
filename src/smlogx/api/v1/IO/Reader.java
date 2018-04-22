package smlogx.api.v1.IO;

import smlogx.api.v1.Interfaces.IO.IReader;
import kotlin.text.Charsets;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader implements IReader {

    private File file = null;
    private String filename = "log.txt";

    public Reader() {
        initPath();
    }

    public Reader(String pathRef) {
        this.filename = pathRef;
        initPath();
    }

    private boolean initPath() {
        try {
            file = new File(this.filename);
            return true;
        } catch (Exception io) {
            io.printStackTrace();
        }
        return false;
    }

    public String getText() {
        try {
            Files.lines(Paths.get(this.filename), Charsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
