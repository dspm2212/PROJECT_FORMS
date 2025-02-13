/**
 * This file contains the definition of the service class for forms.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app.services;

import org.springframework.stereotype.Service;

/**
 * Service class for handling form operations. This class provides methods
 * for saving form data.
 */
@Service
public class FormService {

    /**
     * Saves the provided form data to a file.
     *
     * @param formData The form data to save.
     */
    public void saveFormData(String formData) {
        FileManager.getInstance().saveToFile("form_data.json", formData);
    }
}
