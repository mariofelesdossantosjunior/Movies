
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

    public String getmResponse() {
        return mResponse;
    }

    public void setmResponse(String mResponse) {
        this.mResponse = mResponse;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getmTotalResults() {
        return mTotalResults;
    }

    public void setmTotalResults(String mTotalResults) {
        this.mTotalResults = mTotalResults;
    }

    @Override
    public String toString() {
        return "MovieSearchResult{" +
                "mResponse='" + mResponse + '\'' +
                ", movies=" + movies +
                ", mTotalResults='" + mTotalResults + '\'' +
                '}';
    }
}
