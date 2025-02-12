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
 * Utility class for handling file operations with JSON.
 */
public class FileManager {
    private static final String USER_FILE = "users.json";
    private static final String FORM_FILE = "forms.json";
    private static final String RESPONSE_FILE = "responses.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // Register module to handle Java 8 LocalDateTime
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    // --- USER MANAGEMENT ---
    public static void saveUsers(List<User> users) throws IOException {
        mapper.writeValue(new File(USER_FILE), users);
    }

    public static List<User> loadUsers() {
        return loadFromFile(USER_FILE, User.class);
    }

    // --- FORM MANAGEMENT ---
    public static void saveForms(List<Form> forms) throws IOException {
        mapper.writeValue(new File(FORM_FILE), forms);
    }

    public static List<Form> loadForms() {
        return loadFromFile(FORM_FILE, Form.class);
    }

    // --- RESPONSE MANAGEMENT ---
    public static void saveResponses(List<Response> responses) throws IOException {
        mapper.writeValue(new File(RESPONSE_FILE), responses);
    }

    public static List<Response> loadResponses() {
        return loadFromFile(RESPONSE_FILE, Response.class);
    }

    // --- GENERIC LOADER ---
    public static <T> List<T> loadFromFile(String fileName, Class<T> clazz) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try {
            return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void saveToFile(String filePath, List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }
}
