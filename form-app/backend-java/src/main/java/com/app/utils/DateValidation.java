package com.app.utils;

import java.time.LocalDate;

/**
 * Validation strategy for date-based questions.
 */
public class DateValidation implements ValidationStrategy {
    @Override
    public boolean validate(String response) {
        try {
            LocalDate.parse(response);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
