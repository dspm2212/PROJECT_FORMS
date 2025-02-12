package com.app.controllers;

import java.util.ArrayList;
import java.util.List;

import com.app.models.questions.Question;

/**
 * Controller for managing questions.
 */
public class QuestionController {
    private List<Question> questions;

    public QuestionController() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getAllQuestions() {
        return questions;
    }
}
