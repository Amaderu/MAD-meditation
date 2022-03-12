package com.example.madmeditation.common;

import android.util.Log;
import android.webkit.URLUtil;

import com.google.gson.annotations.SerializedName;

import java.net.URI;
import java.net.URLDecoder;

public class Quotes {
    int id;
    String title;
    @SerializedName("image")
    String imageUrl;
    String description;

    public Quotes(int id, String title, String imageUrl, String description) {
        this.id = id;
        this.title = title;
        if(imageUrl.contains("\\"))
            imageUrl = imageUrl.replace("\\","");
        this.imageUrl = imageUrl;
        Log.e("ohhh", String.format("Quotes: %s",imageUrl));
        this.description = description;
    }
    public Quotes(Quotes quotes){
        this.id = quotes.id;
        this.title = quotes.title;
        if(quotes.imageUrl.contains("\\"))
            quotes.imageUrl = imageUrl.replace("\\","");
        this.imageUrl = quotes.imageUrl;
        this.description = quotes.description;
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
