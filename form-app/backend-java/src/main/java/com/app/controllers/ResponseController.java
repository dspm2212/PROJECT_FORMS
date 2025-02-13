/**
 * This file contains the definition of the controller for managing form responses.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.controllers;

import com.app.models.Response;
import com.app.utils.FileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Controller for managing responses to forms. This class handles the saving and
 * retrieval of responses, persisting them in JSON format.
 */
public class ResponseController {
    private static final String FILE_PATH = "responses.json"; // Path to the responses file
    private List<Response> responses; // List to store all responses
    private AtomicInteger responseIdCounter; // Counter for generating unique response IDs

    /**
     * Initializes the ResponseController by loading existing responses from storage
     * and setting up the response ID counter.
     */
    public ResponseController() {
        this.responses = FileManager.loadFromFile(FILE_PATH, Response.class);
        // Initialize the ID counter based on the highest existing response ID
        this.responseIdCounter = new AtomicInteger(
            responses.stream().mapToInt(Response::getId).max().orElse(0) + 1
        );
    }

    /**
     * Saves a response to a form and persists it in JSON.
     *
     * @param formId The ID of the form being responded to.
     * @param userId The ID of the user submitting the response.
     * @param answers The list of answers provided by the user.
     */
    public void saveResponse(int formId, String userId, List<String> answers) {
        Response response = new Response(responseIdCounter.getAndIncrement(), formId, userId, answers);
        responses.add(response);
        saveResponses(); // Persist the updated list of responses
    }

    /**
     * Retrieves all responses for a specific form.
     *
     * @param formId The ID of the form to fetch responses for.
     * @return A list of responses for the specified form.
     */
    public List<Response> getResponsesByFormId(int formId) {
        List<Response> formResponses = new ArrayList<>();
        for (Response response : responses) {
            if (response.getFormId() == formId) {
                formResponses.add(response);
            }
        }
        return formResponses;
    }

    /**
     * Submits a response to a form and saves it to the JSON file.
     *
     * @param formId The ID of the form being responded to.
     * @param userId The ID of the user submitting the response.
     * @param answers The list of answers provided by the user.
     */
    public void submitResponse(int formId, String userId, List<String> answers) {
        int responseId = UUID.randomUUID().hashCode(); // Generate a unique ID for the response
        Response response = new Response(responseId, formId, userId, answers);
        responses.add(response);
        FileManager.saveToFile("responses.json", responses); // Persist the updated list of responses
    }

    /**
     * Saves the current list of responses to persistent storage.
     */
    private void saveResponses() {
        FileManager.saveToFile(FILE_PATH, responses);
    }
}
