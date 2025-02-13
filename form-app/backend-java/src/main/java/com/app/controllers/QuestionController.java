/**
 * This file contains the definition of the controller for managing questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.controllers;

import java.util.ArrayList;
import java.util.List;

import com.app.models.questions.Question;

/**
 * Controller for managing questions. This class handles the addition and retrieval
 * of questions.
 */
public class QuestionController {
    private List<Question> questions; // List to store all questions

    /**
     * Initializes the QuestionController with an empty list of questions.
     */
    public QuestionController() {
        this.questions = new ArrayList<>();
    }

    /**
     * Adds a new question to the list of questions.
     *
     * @param question The question to add.
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Retrieves all questions stored in the system.
     *
     * @return A list of all questions.
     */
    public List<Question> getAllQuestions() {
        return questions;
    }
}
