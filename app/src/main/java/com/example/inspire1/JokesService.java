package com.example.inspire1;

import com.example.inspire1.entities.Jokes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokesService {

    //GET method to call the endpoints of the API.
    //Call method which will be used in the Main Activity to GET what we need.
    @GET("/jokes/random?category=dev")
    Call<Jokes> getJokes();
}
