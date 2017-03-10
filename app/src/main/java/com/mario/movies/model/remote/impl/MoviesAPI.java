package com.mario.movies.model.remote.impl;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.mario.movies.model.remote.IMoviesAPI;
import com.mario.movies.util.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Mario Feles dos Santos Junior
 * @email <mario_feles@live.com/>
 * @project Movies
 * @since 10/03/17 - 14:12
 */

public class MoviesAPI {
    private static MoviesAPI sInstance;
    private IMoviesAPI mMoviesAPI;

    private MoviesAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setFieldNamingStrategy(
                                FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        this.mMoviesAPI = retrofit.create(IMoviesAPI.class);
    }

    public static MoviesAPI getInstance() {
        if (sInstance == null) {
            synchronized (MoviesAPI.class) {
                if (sInstance == null) sInstance = new MoviesAPI();
            }
        }
        return sInstance;
    }

    public IMoviesAPI getAPI() {
        return mMoviesAPI;
    }
}
