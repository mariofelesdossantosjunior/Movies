
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

    public String getmImdbID() {
        return mImdbID;
    }

    public void setmImdbID(String mImdbID) {
        this.mImdbID = mImdbID;
    }

    public String getmPoster() {
        return mPoster;
    }

    public void setmPoster(String mPoster) {
        this.mPoster = mPoster;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmYear() {
        return mYear;
    }

    public void setmYear(String mYear) {
        this.mYear = mYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mImdbID='" + mImdbID + '\'' +
                ", mPoster='" + mPoster + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mType='" + mType + '\'' +
                ", mYear='" + mYear + '\'' +
                '}';
    }
}
