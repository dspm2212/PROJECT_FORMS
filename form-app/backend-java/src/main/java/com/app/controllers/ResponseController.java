package com.app.controllers;

import com.app.models.Response;
import com.app.utils.FileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Controller for managing responses to forms with JSON persistence.
 */
public class ResponseController {
    private static final String FILE_PATH = "responses.json";
    private List<Response> responses;
    private AtomicInteger responseIdCounter;

    public ResponseController() {
        this.responses = FileManager.loadFromFile(FILE_PATH, Response.class);
        this.responseIdCounter = new AtomicInteger(
            responses.stream().mapToInt(Response::getId).max().orElse(0) + 1
        );
    }

    /**
     * Saves a response to a form and persists it in JSON.
     * @param formId The form ID being responded to.
     * @param userId The user ID submitting the response.
     * @param answers The answers given.
     */
    public void saveResponse(int formId, String userId, List<String> answers) {
        Response response = new Response(responseIdCounter.getAndIncrement(), formId, userId, answers);
        responses.add(response);
        saveResponses();
    }

    /**
     * Retrieves all responses to a specific form.
     * @param formId The form ID to fetch responses for.
     * @return List of responses for the form.
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
    public void submitResponse(int formId, String userId, List<String> answers) {
    int responseId = UUID.randomUUID().hashCode();
    Response response = new Response(responseId, formId, userId, answers);
    responses.add(response);
    FileManager.saveToFile("responses.json", responses);
}

    /**
     * Saves the responses list to the JSON file.
     */
    private void saveResponses() {
        FileManager.saveToFile(FILE_PATH, responses);
    }
}
