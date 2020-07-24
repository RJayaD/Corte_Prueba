package com.example.corteprueba.Services;
import com.example.corteprueba.Models.*;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    public static final String BASE_URL = " https://restcountries.eu/rest/v2/lang/";
    @GET("es")
    Call<List<Datum>> getDatos();
}

