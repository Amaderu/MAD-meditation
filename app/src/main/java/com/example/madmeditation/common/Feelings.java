package com.example.madmeditation.common;

import com.google.gson.annotations.SerializedName;

public class Feelings {
    int id;
    String tittle;
    @SerializedName("image")
    String imageUrl;
    int position;

    public Feelings(int id, String tittle, String imageUrl, int position) {
        this.id = id;
        this.tittle = tittle;
        this.imageUrl = imageUrl;
        this.position = position;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
