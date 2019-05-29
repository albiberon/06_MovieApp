package com.example.movieapp.Retrofit;

import com.example.movieapp.BuildConfig;
import com.example.movieapp.Model.MovieDB;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDatabaseApiService {

    String apiKey = BuildConfig.apiKey;

    @GET("movie?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=true&with_original_language=en")
    Call<MovieDB> getMovies();

    @GET("movie?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&with_original_language=en")
    Call<MovieDB> getMovieYear(@Query("year") String year);
}
