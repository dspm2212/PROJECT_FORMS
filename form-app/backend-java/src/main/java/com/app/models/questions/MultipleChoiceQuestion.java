package com.app.models.questions;

import java.util.List;

/**
 * Represents a multiple-choice question.
 */
public class MultipleChoiceQuestion extends Question {
    private List<String> options;

    public MultipleChoiceQuestion(int id, String text, boolean isMandatory, List<String> options) {
        super(id, text, isMandatory);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public String getQuestionType() {
        return "Multiple Choice";
    }

    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println("Options:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
    public boolean validateAnswer(int selectedOption) {
        return selectedOption >= 1 && selectedOption <= options.size();
    }
}
