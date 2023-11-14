package com.example.per10_retrofit_ppapb.model

import com.google.gson.annotations.SerializedName

data class RickModel(
    @SerializedName("results")
    val results : List<RickData>
)

data class RickData(
    @SerializedName("name")
    val  name :String,
    @SerializedName("status")
    val  status :String,
    @SerializedName("species")
    val  species :String,
    @SerializedName("image")
    val  image :String,
    @SerializedName("gender")
    val  gender :String,
    @SerializedName("location")
    val location: location
)

data class location(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
)