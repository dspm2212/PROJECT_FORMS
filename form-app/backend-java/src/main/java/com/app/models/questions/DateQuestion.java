package com.app.models.questions;

import java.time.LocalDate;

/**
 * Represents a date selection question.
 */
public class DateQuestion extends Question {

    public DateQuestion(int id, String text, boolean isMandatory) {
        super(id, text, isMandatory);
    }

    @Override
    public String getQuestionType() {
        return "Date";
    }

    public boolean validateAnswer(LocalDate date) {
        return date != null;
    }
}
