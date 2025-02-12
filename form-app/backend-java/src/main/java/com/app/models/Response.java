package com.app.models;

import java.util.List;

/**
 * Represents a response to a form.
 */
public class Response {
    private int id;
    private int formId;
    private String userId;
    private List<String> answers;

    public Response(int id, int formId, String userId, List<String> answers) {
        this.id = id;
        this.formId = formId;
        this.userId = userId;
        this.answers = answers;
    }

    public int getId() { return id; }
    public int getFormId() { return formId; }
    public String getUserId() { return userId; }
    public List<String> getAnswers() { return answers; }

    @Override
    public String toString() {
        return "Response{id=" + id + ", formId=" + formId + ", userId='" + userId + "', answers=" + answers + "}";
    }
}
