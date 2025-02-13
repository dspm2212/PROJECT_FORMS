/**
 * This file contains the definition of the controller for managing forms.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.controllers;

import com.app.models.Form;
import com.app.models.questions.Question;
import com.app.utils.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Controller for managing forms. This class handles the creation, retrieval,
 * and persistence of forms.
 */
public class FormController {
    private List<Form> forms; // List to store all forms
    private AtomicInteger formIdCounter; // Counter for generating unique form IDs

    /**
     * Initializes the FormController by loading existing forms from storage
     * and setting up the form ID counter.
     */
    public FormController() {
        this.forms = FileManager.loadForms();
        if (this.forms == null) {
            this.forms = new ArrayList<>();
        }
        // Initialize the ID counter based on the highest existing form ID
        int maxId = forms.stream().mapToInt(Form::getId).max().orElse(0);
        this.formIdCounter = new AtomicInteger(maxId + 1);
    }

    /**
     * Creates a new form with the given title, description, and questions.
     *
     * @param title The title of the form.
     * @param description The description of the form.
     * @param questions The list of questions to include in the form.
     */
    public void createForm(String title, String description, List<Question> questions) {
        int id = formIdCounter.getAndIncrement(); // Generate a unique ID for the form
        Form form = new Form(id, title, description, questions);
        forms.add(form);
        saveForms(); // Persist the updated list of forms
    }

    /**
     * Retrieves all forms stored in the system.
     *
     * @return A list of all forms.
     */
    public List<Form> getAllForms() {
        return forms;
    }

    /**
     * Retrieves a form by its ID.
     *
     * @param id The ID of the form to retrieve.
     * @return The form with the specified ID, or null if not found.
     */
    public Form getFormById(int id) {
        return forms.stream()
                .filter(form -> form.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Saves the current list of forms to persistent storage.
     */
    private void saveForms() {
        try {
            FileManager.saveForms(forms);
        } catch (IOException e) {
            System.out.println("Error saving forms: " + e.getMessage());
        }
    }
}
