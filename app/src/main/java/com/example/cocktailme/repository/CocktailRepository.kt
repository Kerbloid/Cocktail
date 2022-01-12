package com.example.cocktailme.repository

import com.example.cocktailme.api.ApiHelper
import com.example.cocktailme.model.Drink
import com.example.cocktailme.model.DrinkList
import javax.inject.Inject

class CocktailRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getRandomCocktails(): DrinkList {
        val response = apiHelper.getRandomCocktails().execute()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            DrinkList()
        }
    }

}