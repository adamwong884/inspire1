package com.example.inspire1;

import com.example.inspire1.entities.Jokes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokesService {

    @GET("/jokes/random/")
    Call<Jokes> getJokes();
}
