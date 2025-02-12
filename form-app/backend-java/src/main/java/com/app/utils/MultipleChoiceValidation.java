package com.app.utils;

import java.util.List;

/**
 * Validation strategy for multiple-choice questions.
 */
public class MultipleChoiceValidation implements ValidationStrategy {
    private List<String> validOptions;

    public MultipleChoiceValidation(List<String> validOptions) {
        this.validOptions = validOptions;
    }

    @Override
    public boolean validate(String response) {
        return validOptions.contains(response);
    }
}
