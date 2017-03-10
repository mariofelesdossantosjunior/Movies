
package com.mario.movies.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Mario Feles dos Santos Junior
 * @email <mario_feles@live.com/>
 * @project Movies
 * @since 10/03/17 - 14:12
 */
public class MovieSearchResult {
    @SerializedName("Response")
    private String mResponse;
    @SerializedName("Search")
    private List<Movie> movies;
    @SerializedName("totalResults")
    private String mTotalResults;
}
