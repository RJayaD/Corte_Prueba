package com.example.corteprueba;
import com.example.corteprueba.Models.*;
import com.example.corteprueba.Adaptadores.AdapterRecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.corteprueba.Services.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.Rec_Data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Retro();
    }


    public void Retro() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        Call<List<Datum>> reqData = service.getDatos();
        reqData.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                if (!response.isSuccessful()) {
                    Log.i("TAG", "Error" + response.code());
                } else {
                    Log.i("TAG", "Error1" );
                    List<Datum> Datab = response.body();
                    Log.i("TAG", "Error" + Datab.size());
                    adapterRecycler= new AdapterRecycler(Datab);
                    Log.i("TAG", "Error");
                    recyclerView.setAdapter(adapterRecycler);
                    Log.i("TAG", "Erroru");
                }
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                Log.e("TAG", "Error: " + t.getMessage());
            }
        });
    }



}