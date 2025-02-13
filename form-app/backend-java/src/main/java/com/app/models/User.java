/**
 * This file contains the definition of the class for users.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.models;

/**
 * Represents a system user. This class stores the user's ID, first name, last name, and email.
 */
public class User {
    private static int idCounter = 1; 
    private String id; 
    private String firstName; 
    private String lastName; 
    private String email; 

    /**
     * Constructs a new User with the specified first name, last name, and email.
     *
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email of the user.
     */
    public User(String firstName, String lastName, String email) {
        this.id = String.valueOf(idCounter++); // Generate a unique ID for the user
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Returns the ID of the user.
     *
     * @return The user ID.
     */
    public String getId() { return id; }

    /**
     * Returns the first name of the user.
     *
     * @return The first name.
     */
    public String getFirstName() { return firstName; }

    /**
     * Returns the last name of the user.
     *
     * @return The last name.
     */
    public String getLastName() { return lastName; }

    /**
     * Returns the email of the user.
     *
     * @return The email.
     */
    public String getEmail() { return email; }

    /**
     * Returns a string representation of the user.
     *
     * @return A string containing the user's details.
     */
    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + firstName + " " + lastName + "', email='" + email + "'}";
    }
}
