package com.app.models.questions;

/**
 * Abstract class representing a general question.
 */
public abstract class Question {
    private int id;
    private String text;
    private boolean isMandatory;

    public Question(int id, String text, boolean isMandatory) {
        this.id = id;
        this.text = text;
        this.isMandatory = isMandatory;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public boolean isMandatory() { return isMandatory; }

    public void displayQuestion() {
        System.out.println((isMandatory ? "* " : "") + text);
    }

    public abstract String getQuestionType();
}
