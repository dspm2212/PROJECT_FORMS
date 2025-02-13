/**
 * This file contains the definition of the utility class for managing user data.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.services;

import com.app.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing user data storage and retrieval. This class handles
 * loading and saving users to/from a JSON file.
 */
public class UserManager {
    private static final String USER_FILE = "users.json"; // Path to the users file
    private static final ObjectMapper mapper = new ObjectMapper(); // JSON mapper
    private static List<User> users = new ArrayList<>(); // List to store all users

    /**
     * Static block to load users from the file at startup.
     */
    static {
        try {
            File file = new File(USER_FILE);
            if (file.exists()) {
                users = List.of(mapper.readValue(file, User[].class));
            }
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }

    /**
     * Saves the current list of users to the JSON file.
     */
    private static void saveUsers() {
        try {
            mapper.writeValue(new File(USER_FILE), users);
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }

    /**
     * Creates a new user, stores it, and saves the data.
     *
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email of the user.
     * @return The created user.
     */
    public static User createUser(String firstName, String lastName, String email) {
        User newUser = new User(firstName, lastName, email);
        users.add(newUser);
        saveUsers(); // Persist the updated list of users
        return newUser;
    }

    /**
     * Finds a user by their email.
     *
     * @param email The email to search for.
     * @return The user if found, otherwise null.
     */
    public static User getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves all registered users.
     *
     * @return A list of all users.
     */
    public static List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
