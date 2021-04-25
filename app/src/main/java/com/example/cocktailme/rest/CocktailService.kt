package com.example.cocktailme.rest

import com.example.cocktailme.model.DrinkList
import retrofit2.Call
import retrofit2.http.GET

interface CocktailService {

    @GET("random.php")
    fun getRandomCocktail(): Call<DrinkList>
}