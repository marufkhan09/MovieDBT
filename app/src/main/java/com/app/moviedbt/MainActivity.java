package com.app.moviedbt;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Step 1: Find the RecyclerView
        recyclerView = findViewById(R.id.recycleView);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getMovies().enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<MovieModel>> call, @NonNull Response<List<MovieModel>> response) {
                if(response.isSuccessful()){

                    if(!response.body().isEmpty()){
                       List<MovieModel> movies = response.body();
                       MovieAdapter adapter;
                       adapter = new MovieAdapter(movies,MainActivity.this);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        recyclerView.setLayoutManager(layoutManager);
                       recyclerView.setAdapter(adapter);
                        Toast.makeText(MainActivity.this, "List fetched", Toast.LENGTH_SHORT).show();
                   }else {
                        Toast.makeText(MainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<MovieModel>> call, @NonNull Throwable throwable) {
                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}