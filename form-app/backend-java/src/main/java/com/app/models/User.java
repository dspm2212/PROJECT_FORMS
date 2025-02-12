package com.app.models;

import java.util.UUID;

/**
 * Represents a system user.
 */
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructor that generates a unique ID for the user.
     * @param firstName User's first name.
     * @param lastName User's last name.
     * @param email User's email address.
     */
    public User(String firstName, String lastName, String email) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + firstName + " " + lastName + "', email='" + email + "'}";
    }
}
