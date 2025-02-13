/**
 * This file contains the definition of the class for date-based questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.models.questions;

import java.time.LocalDate;

/**
 * Represents a date selection question. This type of question allows users to
 * select a date as their response.
 */
public class DateQuestion extends Question {

    /**
     * Constructs a new DateQuestion with the specified ID, text, and mandatory status.
     *
     * @param id The unique identifier for the question.
     * @param text The text of the question.
     * @param isMandatory Indicates if the question is mandatory.
     */
    public DateQuestion(int id, String text, boolean isMandatory) {
        super(id, text, isMandatory);
    }

    /**
     * Returns the type of the question.
     *
     * @return "Date".
     */
    @Override
    public String getQuestionType() {
        return "Date";
    }

    /**
     * Validates the provided date answer.
     *
     * @param date The date to validate.
     * @return True if the date is not null, false otherwise.
     */
    public boolean validateAnswer(LocalDate date) {
        return date != null;
    }
}
