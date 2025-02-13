/**
 * This file contains the implementation of the validation strategy for multiple-choice questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.utils;

import java.util.List;


/**
 * Validation strategy for multiple-choice questions. This class validates if a response
 * is one of the valid options provided.
 */
public class MultipleChoiceValidation implements ValidationStrategy {
    private List<String> validOptions; // List of valid options for the question

    /**
     * Constructs a new MultipleChoiceValidation with the specified valid options.
     *
     * @param validOptions The list of valid options for the question.
     */
    public MultipleChoiceValidation(List<String> validOptions) {
        this.validOptions = validOptions;
    }

    /**
     * Validates if the provided response is one of the valid options.
     *
     * @param response The response to validate.
     * @return True if the response is a valid option, false otherwise.
     */
    @Override
    public boolean validate(String response) {
        return validOptions.contains(response); // Check if the response is in the valid options list
    }
}
