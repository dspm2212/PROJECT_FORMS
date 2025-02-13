/**
 * This file contains the definition of the class for file handling.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.services;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Singleton class for handling file operations. This class provides methods
 * for saving and loading data to/from files.
 */
public class FileManager {
    private static FileManager instance; // Singleton instance

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private FileManager() {}

    /**
     * Returns the singleton instance of FileManager. If the instance does not exist,
     * it is created.
     *
     * @return The singleton instance of FileManager.
     */
    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    /**
     * Saves the given content to a file.
     *
     * @param filename The name of the file to save the content to.
     * @param content The content to save.
     */
    public void saveToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
