package com.app.controllers;

import com.app.models.Response;
import com.app.utils.FileManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Controller for handling user responses.
 */
public class ResponseController {
    private static final Logger logger = Logger.getLogger(ResponseController.class.getName());
    private List<Response> responses = new ArrayList<>();

    public void addResponse(Response response) {
        responses.add(response);
        logger.info("Response added: " + response.toString());
    }

    public void saveResponses() {
        try {
            FileManager.saveResponses(responses);
        } catch (IOException e) {
            logger.severe("Error saving responses: " + e.getMessage());
        }
    }
}
