package com.app.models;

import java.util.List;

/**
 * Represents a question within a form.
 */
public class Question {
    private int id;
    private String text;
    private String type; // multiple_choice, text, date, file, etc.
    private List<String> options; // Only for multiple-choice questions
    private boolean required;

    /**
     * Gets the question ID.
     * @return Question ID.
     */
    public int getId() { return id; }

    /**
     * Sets the question ID.
     * @param id Question ID.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Gets the question text.
     * @return Question text.
     */
    public String getText() { return text; }

    /**
     * Sets the question text.
     * @param text Question text.
     */
    public void setText(String text) { this.text = text; }

    /**
     * Gets the question type.
     * @return Question type.
     */
    public String getType() { return type; }

    /**
     * Sets the question type.
     * @param type Question type.
     */
    public void setType(String type) { this.type = type; }

    /**
     * Gets the list of options for the question.
     * @return List of options.
     */
    public List<String> getOptions() { return options; }

    /**
     * Sets the list of options for the question.
     * @param options List of options.
     */
    public void setOptions(List<String> options) { this.options = options; }

    /**
     * Checks if the question is required.
     * @return true if required, false otherwise.
     */
    public boolean isRequired() { return required; }

    /**
     * Sets whether the question is required.
     * @param required true if required, false otherwise.
     */
    public void setRequired(boolean required) { this.required = required; }
}