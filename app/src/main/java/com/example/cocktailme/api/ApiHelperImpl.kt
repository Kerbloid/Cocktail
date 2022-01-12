package com.example.cocktailme.api

import com.example.cocktailme.model.DrinkList
import retrofit2.Call
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getRandomCocktails(): Call<DrinkList> = apiService.getRandomCocktails()

}