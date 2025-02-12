package com.app.utils;

import java.time.LocalTime;

/**
 * Validation strategy for time-based questions.
 */
public class TimeValidation implements ValidationStrategy {
    @Override
    public boolean validate(String response) {
        try {
            LocalTime.parse(response);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
