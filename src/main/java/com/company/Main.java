package com.company;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;


public class Main {



    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("src/main/java/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        Menu menu = new Menu();
        menu.start();
        return;
    }
}
