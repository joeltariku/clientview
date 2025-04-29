package com.clientview.clientview;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class FeedbackData {
    long id;
    @JsonProperty("product_name")
    String productName;
    String content;

    @JsonProperty("metadata")
    Map<String,String> metaData;

    @JsonProperty("user_data")
    UserData author;

    public FeedbackData() {}
    public FeedbackData(long id, String pn, String c, Map<String,String> md, UserData ud) {
        this.id = id;
        productName = pn;
        content = c;
        metaData = md;
        author = ud;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String,String> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String,String> metaData) {
        this.metaData = metaData;
    }

    public UserData getAuthor() {return author;}

    public void setAuthor(UserData author) {this.author = author;}
}