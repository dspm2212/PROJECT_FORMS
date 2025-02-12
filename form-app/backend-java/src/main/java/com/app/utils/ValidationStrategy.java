package com.app.utils;

/**
 * Interface for different question validation strategies.
 */
public interface ValidationStrategy {
    boolean validate(String response);
}
