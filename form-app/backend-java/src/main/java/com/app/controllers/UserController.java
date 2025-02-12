package com.app.controllers;

import com.app.models.User;
import com.app.utils.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing users.
 */
public class UserController {
    private List<User> users;

    public UserController() {
        this.users = FileManager.loadUsers();
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
    }

    public User createUser(String firstName, String lastName, String email) {
        User user = new User(firstName, lastName, email);
        users.add(user);
        saveUsers();
        return user;
    }

    public User getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    private void saveUsers() {
        try {
            FileManager.saveUsers(users);
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}
