/**
 * This file contains the implementation of the validation strategy for time-based questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */

package com.app.utils;

import java.time.LocalTime;

/**
 * Validation strategy for time-based questions. This class validates if a response
 * is a valid time in the format expected by LocalTime.
 */
public class TimeValidation implements ValidationStrategy {

    /**
     * Validates if the provided response is a valid time.
     *
     * @param response The response to validate.
     * @return True if the response is a valid time, false otherwise.
     */
    @Override
    public boolean validate(String response) {
        try {
            LocalTime.parse(response); // Attempt to parse the response as a LocalTime
            return true; // Return true if parsing is successful
        } catch (Exception e) {
            return false; // Return false if parsing fails (invalid time format)
        }
    }
}
