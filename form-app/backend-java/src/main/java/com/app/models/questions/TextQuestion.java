package com.app.models.questions;

/**
 * Represents an open-text question.
 */
public class TextQuestion extends Question {

    public TextQuestion(int id, String text, boolean isMandatory) {
        super(id, text, isMandatory);
    }

    @Override
    public String getQuestionType() {
        return "Text";
    }
}
