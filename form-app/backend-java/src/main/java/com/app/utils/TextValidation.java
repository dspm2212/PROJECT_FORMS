/**
 * This file contains the implementation of the validation strategy for text-based questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */

package com.app.utils;

/**
 * Validation strategy for text-based questions. This class validates if a response
 * is not null and not empty.
 */
public class TextValidation implements ValidationStrategy {

    /**
     * Validates if the provided response is not null and not empty.
     *
     * @param response The response to validate.
     * @return True if the response is valid, false otherwise.
     */
    @Override
    public boolean validate(String response) {
        return response != null && !response.trim().isEmpty(); // Check if the response is non-null and non-empty
    }
}
