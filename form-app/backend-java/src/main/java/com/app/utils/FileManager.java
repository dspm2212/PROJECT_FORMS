package com.app.utils;

import com.app.models.Form;
import com.app.models.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Utility class for handling file operations.
 */
public class FileManager {
    private static final String FORM_FILE = "forms.json";
    private static final String RESPONSE_FILE = "responses.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new JavaTimeModule()); // Solución para el error con LocalDateTime
    }

    public static void saveForms(List<Form> forms) throws IOException {
        mapper.writeValue(new File(FORM_FILE), forms);
    }

    public static List<Form> loadForms() throws IOException {
        return mapper.readValue(new File(FORM_FILE), mapper.getTypeFactory().constructCollectionType(List.class, Form.class));
    }

    public static void saveResponses(List<Response> responses) throws IOException {
        mapper.writeValue(new File(RESPONSE_FILE), responses);
    }
}
