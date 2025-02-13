/**
 * This file contains the definition of the class for time-based questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.models.questions;

import java.time.LocalTime;

/**
 * Represents a time selection question. This type of question allows users to
 * select a time as their response.
 */
public class TimeQuestion extends Question {

    /**
     * Constructs a new TimeQuestion with the specified ID, text, and mandatory status.
     *
     * @param id The unique identifier for the question.
     * @param text The text of the question.
     * @param isMandatory Indicates if the question is mandatory.
     */
    public TimeQuestion(int id, String text, boolean isMandatory) {
        super(id, text, isMandatory);
    }

    /**
     * Returns the type of the question.
     *
     * @return "Time".
     */
    @Override
    public String getQuestionType() {
        return "Time";
    }

    /**
     * Validates the provided time answer.
     *
     * @param time The time to validate.
     * @return True if the time is not null, false otherwise.
     */
    public boolean validateAnswer(LocalTime time) {
        return time != null;
    }
}
