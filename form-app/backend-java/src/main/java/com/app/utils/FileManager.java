/**
 * This file contains the utility class for handling file operations with JSON.
 * It manages the saving and loading of users, forms, and responses.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.utils;

import com.app.models.Form;
import com.app.models.Response;
import com.app.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for handling file operations with JSON. This class provides methods
 * to save and load users, forms, and responses to/from JSON files.
 */
public class FileManager {
    private static final String USER_FILE = "users.json"; // File path for storing users
    private static final String FORM_FILE = "forms.json"; // File path for storing forms
    private static final String RESPONSE_FILE = "responses.json"; // File path for storing responses
    private static final ObjectMapper mapper = new ObjectMapper(); // JSON mapper for serialization/deserialization

    static {
        // Register module to handle Java 8 LocalDateTime
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Disable timestamp formatting
    }

    // --- USER MANAGEMENT ---

    /**
     * Saves a list of users to the users JSON file.
     *
     * @param users The list of users to save.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void saveUsers(List<User> users) throws IOException {
        mapper.writeValue(new File(USER_FILE), users);
    }

    /**
     * Loads a list of users from the users JSON file.
     *
     * @return A list of users loaded from the file, or an empty list if the file does not exist.
     */
    public static List<User> loadUsers() {
        return loadFromFile(USER_FILE, User.class);
    }

    // --- FORM MANAGEMENT ---

    /**
     * Saves a list of forms to the forms JSON file.
     *
     * @param forms The list of forms to save.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void saveForms(List<Form> forms) throws IOException {
        mapper.writeValue(new File(FORM_FILE), forms);
    }

    /**
     * Loads a list of forms from the forms JSON file.
     *
     * @return A list of forms loaded from the file, or an empty list if the file does not exist.
     */
    public static List<Form> loadForms() {
        return loadFromFile(FORM_FILE, Form.class);
    }

    // --- RESPONSE MANAGEMENT ---

    /**
     * Saves a list of responses to the responses JSON file.
     *
     * @param responses The list of responses to save.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void saveResponses(List<Response> responses) throws IOException {
        mapper.writeValue(new File(RESPONSE_FILE), responses);
    }

    /**
     * Loads a list of responses from the responses JSON file.
     *
     * @return A list of responses loaded from the file, or an empty list if the file does not exist.
     */
    public static List<Response> loadResponses() {
        return loadFromFile(RESPONSE_FILE, Response.class);
    }

    // --- GENERIC LOADER ---

    /**
     * Loads a list of objects from a JSON file.
     *
     * @param fileName The name of the file to load from.
     * @param clazz The class of the objects to load.
     * @param <T> The type of the objects to load.
     * @return A list of objects loaded from the file, or an empty list if the file does not exist.
     */
    public static <T> List<T> loadFromFile(String fileName, Class<T> clazz) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>(); // Return an empty list if the file does not exist
        }
        try {
            return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace if an error occurs
            return new ArrayList<>(); // Return an empty list if an error occurs
        }
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Saves a list of objects to a JSON file.
     *
     * @param filePath The path of the file to save to.
     * @param data The list of objects to save.
     * @param <T> The type of the objects to save.
     */
    public static <T> void saveToFile(String filePath, List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage()); // Print an error message if saving fails
        }
    }
}
