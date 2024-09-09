package Singleton;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getInstance();
        logger.setFileName("newFile.txt");
        logger.write("Simulation started");
        logger.write("\nProcessing data...");
        logger.write("\nSimulation finished");
        logger.close();
    }
}