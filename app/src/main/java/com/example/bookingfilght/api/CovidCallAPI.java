package com.example.bookingfilght.api;

import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.Models.CovidDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface CovidCallAPI {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    CovidCallAPI callapi = new Retrofit.Builder().baseUrl("https://corona.lmao.ninja/v2/countries/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CovidCallAPI.class);

    @GET("vietnam")
    Call<CovidDTO> getAll();

}
