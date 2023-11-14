package com.example.ppab_retrofit_2.Network


import com.example.per10_retrofit_ppapb.model.RickModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getCharacters(): Call<RickModel>
}