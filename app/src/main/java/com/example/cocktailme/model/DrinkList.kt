package com.example.cocktailme.model


import com.google.gson.annotations.SerializedName

data class DrinkList(
    @SerializedName("drinks")
    val drinks: List<Drink>? = null
)