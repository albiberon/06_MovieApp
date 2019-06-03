package com.example.movieapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.movieapp.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MovieListAdapter movieListAdapter;
    private RecyclerView rvMovieList;
    private List<Movie> movieList = new ArrayList<>();
    private ImageView posterImage;
    private Button btnMovies;
    private EditText yearEt;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        movieListAdapter = new MovieListAdapter(this, movieList);
        rvMovieList = findViewById(R.id.movieList);
        rvMovieList.setAdapter(movieListAdapter);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        rvMovieList.setLayoutManager(gridLayoutManager);

        posterImage = findViewById(R.id.posterImage);
        btnMovies = findViewById(R.id.submitButton);
        yearEt = findViewById(R.id.yearText);
        btnMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getMovieYear(yearEt.getText().toString());
            }
        });

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                showToast(s);
            }
        });
        viewModel.getMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                movieList = movies;
                updateUI();
            }
        });




    }


    private void updateUI() {
        if (movieListAdapter == null) {
            movieListAdapter = new MovieListAdapter(this, movieList);
            rvMovieList.setAdapter(movieListAdapter);
        } else {
            movieListAdapter.swapList(movieList);
        }
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG)
                .show();
    }
}