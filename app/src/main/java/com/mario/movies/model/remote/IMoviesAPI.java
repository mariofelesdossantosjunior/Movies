package com.mario.movies.model.remote;

import com.mario.movies.model.entity.MovieSearchResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author Mario Feles dos Santos Junior
 * @email <mario_feles@live.com/>
 * @project Movies
 * @since 10/03/17 - 14:12
 */

public interface IMoviesAPI {
    @GET("./")
    Observable<MovieSearchResult> search(@Query("s") String q);
}