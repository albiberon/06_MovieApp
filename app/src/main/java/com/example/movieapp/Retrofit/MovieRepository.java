package com.example.movieapp.Retrofit;

import com.example.movieapp.Model.MovieDB;

import retrofit2.Call;

public class MovieRepository {

    private MovieDatabaseApiService movieDatabaseApiService = MovieDatabaseApi.create();

    public Call<MovieDB> getMovies() {
        return movieDatabaseApiService.getMovies();
    }

    public Call<MovieDB> getMovieYear(String year) {
        return movieDatabaseApiService.getMovieYear(year);
    }
}
