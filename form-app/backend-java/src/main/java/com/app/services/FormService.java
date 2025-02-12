package com.app.services;

import org.springframework.stereotype.Service;

/**
 * Service class for handling form operations.
 */
@Service
public class FormService {
    public void saveFormData(String formData) {
        FileManager.getInstance().saveToFile("form_data.json", formData);
    }
}