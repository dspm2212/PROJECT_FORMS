package com.app.utils;

/**
 * Validation strategy for text questions.
 */
public class TextValidation implements ValidationStrategy {
    @Override
    public boolean validate(String response) {
        return response != null && !response.trim().isEmpty();
    }
}

