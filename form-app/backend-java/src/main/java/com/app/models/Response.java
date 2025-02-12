package com.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a response to a form.
 */
public class Response {
    private int formId;
    private String userId;
    private List<Answer> answers;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    public Response(int formId, String userId, List<Answer> answers) {
        this.formId = formId;
        this.userId = userId;
        this.answers = answers;
        this.timestamp = LocalDateTime.now();
    }

    public int getFormId() { return formId; }
    public String getUserId() { return userId; }
    public List<Answer> getAnswers() { return answers; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
