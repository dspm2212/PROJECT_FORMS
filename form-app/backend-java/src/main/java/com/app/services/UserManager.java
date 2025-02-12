package com.app.services;

import com.app.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing user data storage and retrieval.
 */
public class UserManager {
    private static final String USER_FILE = "users.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static List<User> users = new ArrayList<>();

    /**
     * Loads users from the file at startup.
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
     * Saves the list of users to a file.
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
     * @param firstName User's first name.
     * @param lastName User's last name.
     * @param email User's email.
     * @return The created user.
     */
    public static User createUser(String firstName, String lastName, String email) {
        User newUser = new User(firstName, lastName, email);
        users.add(newUser);
        saveUsers();
        return newUser;
    }

    /**
     * Finds a user by email.
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
     * @return List of users.
     */
    public static List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
