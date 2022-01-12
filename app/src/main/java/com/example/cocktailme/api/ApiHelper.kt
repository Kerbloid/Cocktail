package com.example.cocktailme.api

import com.example.cocktailme.model.DrinkList
import retrofit2.Call
import retrofit2.Response

interface ApiHelper {
    suspend fun getRandomCocktails(): Call<DrinkList>
}