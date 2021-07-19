package com.example.bookingfilght.api;

import com.example.bookingfilght.Models.SanBayDTO;
import com.example.bookingfilght.Models.VeChuyenBayDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface VeChuyenBayCallAPI {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    VeChuyenBayCallAPI callapi = new Retrofit.Builder().baseUrl("https://filght.loca.lt/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(VeChuyenBayCallAPI.class);

    @GET("vechuyenbay")
    Call<List<VeChuyenBayDTO>> getAll();

}
