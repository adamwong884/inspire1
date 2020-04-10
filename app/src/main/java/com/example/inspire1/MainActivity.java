package com.example.inspire1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inspire1.entities.Jokes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView quote;
    private Button refresh;
    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    quote = (TextView)findViewById(R.id.tvQuote);
    refresh = (Button)findViewById(R.id.bRefresh);



    refresh.setOnClickListener(v -> {

    //Converting JSON response String into a Jav Object by using the GSON Converter
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        Log.d(TAG, "onClick: Success");
    //Implementing the JokesService Interface using the retrofit create method (bringing the interface to life)
    JokesService service = retrofit.create(JokesService.class);

    //Implementing the method in the interface
    Call<Jokes> jokesCall = service.getJokes();

    jokesCall.enqueue(new Callback<Jokes>() {
        @Override
        public void onResponse(Call<Jokes> call, Response<Jokes> response) {
            Log.d(TAG, "onSuccess: Success");

            //Creating Joke class instance

            Jokes jokes = response.body();
            quote.setText(jokes.getValue());

        }

        @Override
        public void onFailure(Call<Jokes> call, Throwable t) {

            Log.d(TAG, "onFailure: failure");
        }
    });
});
    }
}

