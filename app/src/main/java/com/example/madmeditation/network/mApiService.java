package com.example.madmeditation.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mApiService {
    private static mApiService mInstance;
    private static final String BASE_URL = "http://mskko2021.mad.hakta.pro/api/";
    private Retrofit mRetrofit;

    public static mApiService getInstance() {
        if (mInstance == null) {
            mInstance = new mApiService();
        }
        return mInstance;
    }
    private mApiService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        Gson gson = new GsonBuilder().setLenient().create();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client.build())
                .build();
    }
    public mApi getApi() {
        return mRetrofit.create(mApi.class);
    }
}
