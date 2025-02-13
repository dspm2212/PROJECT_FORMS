/**
 * This file contains the definition of the class for forms.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
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

    /**
     * Constructs a new Form with the specified ID, title, description, and list of questions.
     *
     * @param id The unique identifier for the form.
     * @param title The title of the form.
     * @param description The description of the form.
     * @param questions The list of questions in the form.
     */
    public Form(int id, String title, String description, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    /**
     * Returns the ID of the form.
     *
     * @return The form ID.
     */
    public int getId() { return id; }

    /**
     * Returns the title of the form.
     *
     * @return The form title.
     */
    public String getTitle() { return title; }

    /**
     * Returns the description of the form.
     *
     * @return The form description.
     */
    public String getDescription() { return description; }

    /**
     * Returns the list of questions in the form.
     *
     * @return The list of questions.
     */
    public List<Question> getQuestions() { return questions; }

    /**
     * Displays the form's title, description, and all its questions.
     */
    public void displayForm() {
        System.out.println("Form: " + title);
        System.out.println(description);
        for (Question q : questions) {
            q.displayQuestion();
        }
    }
}
