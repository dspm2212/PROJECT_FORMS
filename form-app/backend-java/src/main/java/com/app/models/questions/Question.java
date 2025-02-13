/**
 * This file contains the definition of the base class for questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.models.questions;

/**
 * Abstract class representing a general question. This class serves as the base
 * for different types of questions, such as text, date, time, and multiple-choice questions.
 */
public abstract class Question {
    private int id; // Unique identifier for the question
    private String text; // The text of the question
    private boolean isMandatory; // Indicates if the question is mandatory

    /**
     * Constructs a new Question with the specified ID, text, and mandatory status.
     *
     * @param id The unique identifier for the question.
     * @param text The text of the question.
     * @param isMandatory Indicates if the question is mandatory.
     */
    public Question(int id, String text, boolean isMandatory) {
        this.id = id;
        this.text = text;
        this.isMandatory = isMandatory;
    }

    /**
     * Returns the ID of the question.
     *
     * @return The question ID.
     */
    public int getId() { return id; }

    /**
     * Returns the text of the question.
     *
     * @return The question text.
     */
    public String getText() { return text; }

    /**
     * Indicates if the question is mandatory.
     *
     * @return True if the question is mandatory, false otherwise.
     */
    public boolean isMandatory() { return isMandatory; }

    /**
     * Displays the question text, prefixed with an asterisk if it is mandatory.
     */
    public void displayQuestion() {
        System.out.println((isMandatory ? "* " : "") + text);
    }

    /**
     * Returns the type of the question. This method must be implemented by subclasses.
     *
     * @return The type of the question.
     */
    public abstract String getQuestionType();
}
