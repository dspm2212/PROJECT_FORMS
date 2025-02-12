package com.app.models;

/**
 * Represents an answer to a specific question.
 */
public class Answer {
    private int questionId;
    private String answer;

    // Nuevo constructor corregido
    public Answer(int questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public int getQuestionId() { return questionId; }
    public void setQuestionId(int questionId) { this.questionId = questionId; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
}
