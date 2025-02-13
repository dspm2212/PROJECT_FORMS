/**
 * This file contains the definition of the class for multiple-choice questions.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.models.questions;

import java.util.List;

/**
 * Represents a multiple-choice question. This type of question allows users to
 * select one option from a predefined list of options.
 */
public class MultipleChoiceQuestion extends Question {
    private List<String> options; // List of options for the question

    /**
     * Constructs a new MultipleChoiceQuestion with the specified ID, text, mandatory status,
     * and list of options.
     *
     * @param id The unique identifier for the question.
     * @param text The text of the question.
     * @param isMandatory Indicates if the question is mandatory.
     * @param options The list of options for the question.
     */
    public MultipleChoiceQuestion(int id, String text, boolean isMandatory, List<String> options) {
        super(id, text, isMandatory);
        this.options = options;
    }

    /**
     * Returns the list of options for the question.
     *
     * @return The list of options.
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * Returns the type of the question.
     *
     * @return "Multiple Choice".
     */
    @Override
    public String getQuestionType() {
        return "Multiple Choice";
    }

    /**
     * Displays the question text and its options.
     */
    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println("Options:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    /**
     * Validates the selected option.
     *
     * @param selectedOption The option selected by the user.
     * @return True if the selected option is valid, false otherwise.
     */
    public boolean validateAnswer(int selectedOption) {
        return selectedOption >= 1 && selectedOption <= options.size();
    }
}
