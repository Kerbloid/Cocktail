package com.example.cocktailme.rest

import com.example.cocktailme.model.DrinkList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {

    @GET("random.php")
    fun getRandomCocktail(): Call<DrinkList>

    @GET("randomselection.php")
    fun getRandomCocktails(): Call<DrinkList>

    @GET("popular.php")
    fun getPopular(): Call<DrinkList>

    @GET("latest.php")
    fun getLatest(): Call<DrinkList>

    @GET("search.php")
    fun searchByName(@Query("s") name: String)

    @GET("filter.php")
    fun searchByIngredient(@Query("i") ingredient: String)


}