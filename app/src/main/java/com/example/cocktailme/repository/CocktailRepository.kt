package com.example.cocktailme.repository

import com.example.cocktailme.model.Drink
import com.example.cocktailme.rest.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object CocktailRepository {

    private val cocktailService = RetrofitClient.service

    suspend fun getRandomCocktail(): List<Drink>? = withContext(Dispatchers.IO) {
        val response = cocktailService.getRandomCocktail().execute()
        return@withContext if (response.isSuccessful) {
            response.body()?.drinks
        } else {
            null
        }
    }

    suspend fun getPopularCocktails(): List<Drink>? = withContext(Dispatchers.IO) {
        val response = cocktailService.getPopular().execute()
        return@withContext if (response.isSuccessful) {
            response.body()?.drinks
        } else {
            null
        }
    }
}