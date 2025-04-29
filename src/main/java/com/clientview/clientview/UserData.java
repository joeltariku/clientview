package com.clientview.clientview;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserData {
    @JsonProperty("id")
    long id;
    String name;
    String email;

    List<FeedbackData> feedbackData;

    public UserData(String name, String email, long id, List<FeedbackData> feedbackData) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.feedbackData = feedbackData;
    }

    public UserData() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<FeedbackData> getFeedbackData() { return feedbackData; }
}
