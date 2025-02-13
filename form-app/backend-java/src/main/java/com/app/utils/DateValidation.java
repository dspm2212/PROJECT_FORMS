/**
 * This file contains the implementation of the validation strategy for date-based questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.utils;

import java.time.LocalDate;

/**
 * Validation strategy for date-based questions. This class validates if a response
 * is a valid date in the format expected by LocalDate.
 */
public class DateValidation implements ValidationStrategy {

    /**
     * Validates if the provided response is a valid date.
     *
     * @param response The response to validate.
     * @return True if the response is a valid date, false otherwise.
     */
    @Override
    public boolean validate(String response) {
        try {
            LocalDate.parse(response); // Attempt to parse the response as a LocalDate
            return true; // Return true if parsing is successful
        } catch (Exception e) {
            return false; // Return false if parsing fails (invalid date format)
        }
    }
}
