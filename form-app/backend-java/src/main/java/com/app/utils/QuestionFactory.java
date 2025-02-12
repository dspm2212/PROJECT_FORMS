package com.app.utils;

import java.util.List;

import com.app.models.questions.*;

/**
 * Factory class to create questions dynamically.
 */
public class QuestionFactory {
    public static Question createQuestion(String type, int id, String text, boolean required, List<String> options) {
        switch (type.toLowerCase()) {
            case "multiple_choice":
                return new MultipleChoiceQuestion(id, text, required, options);
            case "text":
                return new TextQuestion(id, text, required);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }
}
