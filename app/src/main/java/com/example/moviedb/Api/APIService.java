package com.example.moviedb.Api;

import com.example.moviedb.model.VeriListem;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("movie/top_rated?api_key=e48cf818ab7925dbfb85cd4227b26492")
    Call<VeriListem> verilerimilistele();

}
//@GET("api/users")
//Call<VeriListem> verilerimilistele(@Query("page") int deger);
//@Query("page") int deger
//api/users