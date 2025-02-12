package com.app.models;
/**
 * Represents a system user.
 */
public class User {
    private static int idCounter = 1;
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        this.id = String.valueOf(idCounter++);
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
