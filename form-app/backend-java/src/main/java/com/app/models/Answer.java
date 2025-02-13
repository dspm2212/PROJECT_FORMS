/**
 * This file contains the definition of the class for answers to questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.models;

/**
 * Represents an answer to a specific question. This class stores the question ID
 * and the answer provided by the user.
 */
public class Answer {
    private int questionId; // The ID of the question being answered
    private String answer; // The answer provided by the user

    /**
     * Constructs a new Answer with the specified question ID and answer.
     *
     * @param questionId The ID of the question being answered.
     * @param answer The answer provided by the user.
     */
    public Answer(int questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    /**
     * Returns the ID of the question being answered.
     *
     * @return The question ID.
     */
    public int getQuestionId() { return questionId; }

    /**
     * Sets the ID of the question being answered.
     *
     * @param questionId The question ID.
     */
    public void setQuestionId(int questionId) { this.questionId = questionId; }

    /**
     * Returns the answer provided by the user.
     *
     * @return The answer.
     */
    public String getAnswer() { return answer; }

    /**
     * Sets the answer provided by the user.
     *
     * @param answer The answer.
     */
    public void setAnswer(String answer) { this.answer = answer; }
}
