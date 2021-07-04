package com.example.responsi;


import com.example.responsi.ResponseHome;
import com.example.responsi.ResponseList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Respository {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<ResponseHome> getCovid();

    @GET("sebaran_v2/jabar/faskes")
    Call<ResponseList> getHospital();
}

