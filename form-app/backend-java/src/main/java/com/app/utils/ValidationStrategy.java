/**
 * This file contains the interface for different question validation strategies.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.utils;

/**
 * Interface for different question validation strategies. Implementations of this
 * interface define how to validate responses for specific types of questions.
 */
public interface ValidationStrategy {

    /**
     * Validates a response based on the specific strategy.
     *
     * @param response The response to validate.
     * @return True if the response is valid, false otherwise.
     */
    boolean validate(String response);
}
