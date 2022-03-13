package com.example.madmeditation.network;

import androidx.annotation.NonNull;

import com.example.madmeditation.common.Feelings;
import com.example.madmeditation.common.FeelingsResponse;
import com.example.madmeditation.common.Quotes;
import com.example.madmeditation.common.QuotesResponse;
import com.example.madmeditation.common.User;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface mApi {
    @GET("quotes")
    Call<List<Quotes>> getQuotes();
    @GET("quotes")
    Call<QuotesResponse> getQuotes_2();

    @GET("feelings")
    Call<FeelingsResponse> getFeelings();

    @FormUrlEncoded
    @POST("user/login")
    Call<User> authorize(@Field("email") String email, @Field("password") String password);
}
