package com.example.bookingfilght.api;

import com.example.bookingfilght.Models.WeatherMainDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface WeatherCallAPI {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    WeatherCallAPI callapi = new Retrofit.Builder().baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(WeatherCallAPI.class);

    @GET("data/2.5/weather?q=Saigon&appid=2670c00c4187bff5948e73fa9e975370")
    Call<WeatherMainDTO> getAll();
}
