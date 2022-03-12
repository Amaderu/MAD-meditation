package com.example.madmeditation.network;

import com.example.madmeditation.common.Feelings;
import com.example.madmeditation.common.Quotes;
import com.example.madmeditation.common.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface mApi {
    @GET("/quotes")
    Call<List<Quotes>> getQuotes();

    @GET("/feelings")
    Call<List<Feelings>> getFeelings();

    @POST("/user/login")
    Call<User> authorize(@Field("email") String email, @Field("password") String password);
}
