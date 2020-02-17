package com.example.moviedb.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopRated  {
    @SerializedName("poster_path")
    @Expose
    public String posterPath;


    public String getPosterPath(){
        return "https://image.tmdb.org/t/p/w500"+posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
