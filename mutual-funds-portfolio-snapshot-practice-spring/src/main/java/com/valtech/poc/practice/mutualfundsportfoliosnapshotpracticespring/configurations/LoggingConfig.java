package com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.configurations;
import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingConfig {

    public static void configureLogging() {
        Logger rootLogger = Logger.getLogger("");

        rootLogger.setLevel(Level.INFO);

        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);

        try {
            // Check if the log file already exists
            File logFile = new File("logs/application.log");
            boolean appendToFile = logFile.exists();

            // Create FileHandler with the full path to the log file
            FileHandler fileHandler = new FileHandler("logs/application.log", appendToFile);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        rootLogger.addHandler(consoleHandler);
    }
}