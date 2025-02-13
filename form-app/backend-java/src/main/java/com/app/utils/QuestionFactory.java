/**
 * This file contains the factory class for creating questions dynamically.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.utils;

import java.util.List;

import com.app.models.questions.*;

/**
 * Factory class to create questions dynamically based on the provided type.
 */
public class QuestionFactory {

    /**
     * Creates a question of the specified type.
     *
     * @param type The type of question to create (e.g., "multiple_choice", "text").
     * @param id The ID of the question.
     * @param text The text of the question.
     * @param required Indicates if the question is required.
     * @param options The list of options for multiple-choice questions.
     * @return A new question of the specified type.
     * @throws IllegalArgumentException If the question type is unknown.
     */
    public static Question createQuestion(String type, int id, String text, boolean required, List<String> options) {
        switch (type.toLowerCase()) {
            case "multiple_choice":
                return new MultipleChoiceQuestion(id, text, required, options); // Create a multiple-choice question
            case "text":
                return new TextQuestion(id, text, required); // Create a text question
            default:
                throw new IllegalArgumentException("Unknown question type: " + type); // Throw an exception for unknown types
        }
    }
}
