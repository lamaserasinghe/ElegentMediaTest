package com.example.elegant_media;

import com.example.elegant_media.REST_Classes.Details;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
//Define the Endpoints

public interface ApiInterface {

    @GET("hotels.json")
    Call<List<Details>> getHotelDetails();
}
