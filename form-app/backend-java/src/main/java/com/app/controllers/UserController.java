package com.app.controllers;

import com.app.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing users.
 */
public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    /**
     * Creates a new user and stores it in the system.
     * @param firstName User's first name.
     * @param lastName User's last name.
     * @param email User's email address.
     * @return The created user.
     */
    public User createUser(String firstName, String lastName, String email) {
        User newUser = new User(firstName, lastName, email);
        users.add(newUser);
        return newUser;
    }

    /**
     * Finds a user by email.
     * @param email The email to search for.
     * @return The user if found, otherwise null.
     */
    public User getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves all registered users.
     * @return List of users.
     */
    public List<User> getAllUsers() {
        return users;
    }
}
