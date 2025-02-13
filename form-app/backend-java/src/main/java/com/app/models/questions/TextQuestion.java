/**
 * This file contains the definition of the class for text-based questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.models.questions;

/**
 * Represents an open-text question. This type of question allows users to provide
 * a free-form text response.
 */
public class TextQuestion extends Question {

    /**
     * Constructs a new TextQuestion with the specified ID, text, and mandatory status.
     *
     * @param id The unique identifier for the question.
     * @param text The text of the question.
     * @param isMandatory Indicates if the question is mandatory.
     */
    public TextQuestion(int id, String text, boolean isMandatory) {
        super(id, text, isMandatory);
    }

    /**
     * Returns the type of the question.
     *
     * @return "Text".
     */
    @Override
    public String getQuestionType() {
        return "Text";
    }
}
