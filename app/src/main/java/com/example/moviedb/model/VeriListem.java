package com.example.moviedb.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VeriListem {

    @SerializedName("results")
    @Expose
    private List<TopRated> data;

    public List<TopRated> getResults() {
        return data;
    }
}
