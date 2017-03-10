
package com.mario.movies.model.entity;

import com.google.gson.annotations.SerializedName;
/**
 * @author Mario Feles dos Santos Junior
 * @email <mario_feles@live.com/>
 * @project Movies
 * @since 10/03/17 - 14:12
 */
public class Movie {
    @SerializedName("imdbID")
    private String mImdbID;
    @SerializedName("Poster")
    private String mPoster;
    @SerializedName("Title")
    private String mTitle;
    @SerializedName("Type")
    private String mType;
    @SerializedName("Year")
    private String mYear;
}
