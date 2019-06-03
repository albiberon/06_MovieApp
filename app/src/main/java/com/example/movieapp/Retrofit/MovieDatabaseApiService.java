package com.example.movieapp.Retrofit;

import com.example.movieapp.Model.MovieDB;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDatabaseApiService {

    static final String API_KEY = "0fe465275aaf9ad7401c9984612a7a94";

    @GET("movie?api_key=" + API_KEY + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=true&with_original_language=en")
    Call<MovieDB> getMovies();

    @GET("movie?api_key=" + API_KEY + "&language=en-US&sort_by=popularity.desc&with_original_language=en")
    Call<MovieDB> getMovieYear(@Query("year") String year);
}
