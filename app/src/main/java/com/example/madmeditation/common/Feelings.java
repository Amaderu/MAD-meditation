package com.example.madmeditation.common;

import com.google.gson.annotations.SerializedName;

public class Feelings {
    int id;
    String title;
    @SerializedName("image")
    String imageUrl;
    int position;

    public Feelings(int id, String title, String imageUrl, int position) {
        this.id = id;
        this.title = title;
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
        return title;
    }

    public void setTittle(String title) {
        this.title = title;
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
