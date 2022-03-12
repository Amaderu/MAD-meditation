package com.example.madmeditation.network;

import androidx.annotation.NonNull;

import com.example.madmeditation.common.Feelings;
import com.example.madmeditation.common.Quotes;
import com.example.madmeditation.common.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface mApi {
    @GET("/api/quotes")
    Call<List<Quotes>> getQuotes();

    @GET("/api/feelings")
    Call<List<Feelings>> getFeelings();

    @FormUrlEncoded
    @POST("/api/user/login")
    Call<User> authorize(@Field("email") String email, @Field("password") String password);
}
