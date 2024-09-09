package Singleton;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private FileWriter writer;

    private Logger() {
        try {
            writer = new FileWriter("log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String fileName) throws IOException {
        if (writer != null) {
            writer.close();
        }
        try {
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String message) throws IOException {
        writer.write(message);
    }

    public void close() throws IOException {
        writer.close();
    }
}
