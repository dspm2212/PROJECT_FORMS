package com.app.models;

import com.app.models.questions.Question;
import java.util.List;

/**
 * Represents a form with a title, description, and a list of questions.
 */
public class Form {
    private int id;
    private String title;
    private String description;
    private List<Question> questions;

    public Form(int id, String title, String description, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public int getId() { return id;}
    public String getTitle() { return title;}
    public String getDescription() { return description;}
    public List<Question> getQuestions() { return questions;}

    public void displayForm() {
        System.out.println("Form: " + title);
        System.out.println(description);
        for (Question q : questions) {
            q.displayQuestion();
        }
    }
}