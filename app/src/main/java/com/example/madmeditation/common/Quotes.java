package com.example.madmeditation.common;

import com.google.gson.annotations.SerializedName;

public class Quotes {
    int id;
    String tittle;
    @SerializedName("image")
    String imageUrl;
    String description;

    public Quotes(int id, String tittle, String imageUrl, String description) {
        this.id = id;
        this.tittle = tittle;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
