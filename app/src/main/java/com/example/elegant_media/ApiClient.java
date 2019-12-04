package com.example.elegant_media;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Create the Retrofit Instance

public class ApiClient {
    public static final String BASE_URL="https://dl.dropboxusercontent.com/s/6nt7fkdt7ck0lue/";

    public static Retrofit retrofit = null;
    public static Retrofit getApiClient(){
        if(retrofit==null){
            retrofit =new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}