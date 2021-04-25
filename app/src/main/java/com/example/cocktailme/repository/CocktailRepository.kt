package com.example.cocktailme.repository

import com.example.cocktailme.model.DrinkList
import com.example.cocktailme.rest.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object CocktailRepository {

    suspend fun getRandomCocktail(): DrinkList? = withContext(Dispatchers.IO) {
        val response = RetrofitClient.service.getRandomCocktail().execute()
        return@withContext if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}