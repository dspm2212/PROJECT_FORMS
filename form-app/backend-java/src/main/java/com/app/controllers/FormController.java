package com.app.controllers;

import com.app.models.Form;
import com.app.models.questions.Question;
import com.app.utils.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Controller for managing forms.
 */
public class FormController {
    private List<Form> forms;
    private AtomicInteger formIdCounter;

    public FormController() {
        this.forms = FileManager.loadForms();
        if (this.forms == null) {
            this.forms = new ArrayList<>();
        }
        int maxId = forms.stream().mapToInt(Form::getId).max().orElse(0);
        this.formIdCounter = new AtomicInteger(maxId + 1);
    }

    public void createForm(String title, String description, List<Question> questions) {
        int id = formIdCounter.getAndIncrement();
        Form form = new Form(id, title, description, questions);
        forms.add(form);
        saveForms();
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

    private void saveForms() {
        try {
            FileManager.saveForms(forms);
        } catch (IOException e) {
            System.out.println("Error saving forms: " + e.getMessage());
        }
    }
}