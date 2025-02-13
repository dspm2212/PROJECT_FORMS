/**
 * This file contains the definition of the controller for managing users.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.controllers;

import com.app.models.User;
import com.app.utils.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing users. This class handles the creation and retrieval
 * of users, as well as their persistence.
 */
public class UserController {
    private List<User> users; // List to store all users

    /**
     * Initializes the UserController by loading existing users from storage.
     */
    public UserController() {
        this.users = FileManager.loadUsers();
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
    }

    /**
     * Creates a new user with the given details and saves it to storage.
     *
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email of the user.
     * @return The created user.
     */
    public User createUser(String firstName, String lastName, String email) {
        User user = new User(firstName, lastName, email);
        users.add(user);
        saveUsers(); // Persist the updated list of users
        return user;
    }

    /**
     * Retrieves a user by their email.
     *
     * @param email The email of the user to retrieve.
     * @return The user with the specified email, or null if not found.
     */
    public User getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    /**
     * Saves the current list of users to persistent storage.
     */
    private void saveUsers() {
        try {
            FileManager.saveUsers(users);
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}
