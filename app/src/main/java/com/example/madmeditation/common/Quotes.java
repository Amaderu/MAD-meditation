package com.example.madmeditation.common;

import android.util.Log;
import android.webkit.URLUtil;

import com.google.gson.annotations.SerializedName;

import java.net.URI;
import java.net.URLDecoder;

public class Quotes {
    int id;
    String tittle;
    @SerializedName("image")
    String imageUrl;
    String description;

    public Quotes(int id, String tittle, String imageUrl, String description) {
        this.id = id;
        this.tittle = tittle;
        if(imageUrl.contains("\\"))
            imageUrl = imageUrl.replace('\\','\b');
        this.imageUrl = imageUrl;
        Log.e("FUCK", String.format("Quotes: %s",imageUrl));
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
        if(imageUrl.contains("\\"))
            imageUrl = imageUrl.replace('\\','\b');
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
