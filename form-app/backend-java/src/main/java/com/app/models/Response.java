package com.app.models;

import java.util.List;
import java.time.LocalDateTime;

/**
 * Represents a response submitted by a user.
 */
public class Response {
    private int formId;
    private String userId;
    private List<Answer> answers;
    private LocalDateTime timestamp;

    public int getFormId() { return formId; }
    public void setFormId(int formId) { this.formId = formId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public List<Answer> getAnswers() { return answers; }
    public void setAnswers(List<Answer> answers) { this.answers = answers; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
