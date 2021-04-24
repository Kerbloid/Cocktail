package com.example.cocktailme

import retrofit2.Call
import retrofit2.http.GET

interface CocktailService {
    @GET("random.php")
    fun getRandom(): Call<DrinkList>
}