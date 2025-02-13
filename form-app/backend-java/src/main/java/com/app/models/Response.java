/**
 * This file contains the definition of the class for form responses.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.models;

import java.util.List;

/**
 * Represents a response to a form. This class stores the response ID, form ID,
 * user ID, and the list of answers provided by the user.
 */
public class Response {
    private int id; 
    private int formId; 
    private String userId; 
    private List<String> answers; 

    /**
     * Constructs a new Response with the specified ID, form ID, user ID, and list of answers.
     *
     * @param id The unique identifier for the response.
     * @param formId The ID of the form being responded to.
     * @param userId The ID of the user submitting the response.
     * @param answers The list of answers provided by the user.
     */
    public Response(int id, int formId, String userId, List<String> answers) {
        this.id = id;
        this.formId = formId;
        this.userId = userId;
        this.answers = answers;
    }

    /**
     * Returns the ID of the response.
     *
     * @return The response ID.
     */
    public int getId() { return id; }

    /**
     * Returns the ID of the form being responded to.
     *
     * @return The form ID.
     */
    public int getFormId() { return formId; }

    /**
     * Returns the ID of the user submitting the response.
     *
     * @return The user ID.
     */
    public String getUserId() { return userId; }

    /**
     * Returns the list of answers provided by the user.
     *
     * @return The list of answers.
     */
    public List<String> getAnswers() { return answers; }

    /**
     * Returns a string representation of the response.
     *
     * @return A string containing the response details.
     */
    @Override
    public String toString() {
        return "Response{id=" + id + ", formId=" + formId + ", userId='" + userId + "', answers=" + answers + "}";
    }
}
