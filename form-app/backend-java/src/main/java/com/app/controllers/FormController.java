package com.app.controllers;

import com.app.models.Form;
import com.app.models.questions.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Controller for managing forms.
 */
public class FormController {
    private List<Form> forms;
    private static final AtomicInteger idCounter = new AtomicInteger(1); // Generador de IDs únicos

    public FormController() {
        this.forms = new ArrayList<>();
    }

    public int generateFormId() {
        return idCounter.getAndIncrement();
    }

    public void createForm(String title, String description, List<Question> questions) {
        int id = generateFormId(); // Genera un ID único automáticamente
        createForm(id, title, description, questions);
    }

    public void createForm(int id, String title, String description, List<Question> questions) {
        Form form = new Form(id, title, description, questions);
        forms.add(form);
    }

    public List<Form> getAllForms() {
        return forms;
    }

    public Form getFormById(int id) {
        return forms.stream()
                .filter(form -> form.getId() == id)
                .findFirst()
                .orElse(null);
    }
}