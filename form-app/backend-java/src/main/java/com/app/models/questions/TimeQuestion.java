package com.app.models.questions;

import java.time.LocalTime;

/**
 * Represents a time selection question.
 */
public class TimeQuestion extends Question {

    public TimeQuestion(int id, String text, boolean isMandatory) {
        super(id, text, isMandatory);
    }

    @Override
    public String getQuestionType() {
        return "Time";
    }

    public boolean validateAnswer(LocalTime time) {
        return time != null;
    }
}
