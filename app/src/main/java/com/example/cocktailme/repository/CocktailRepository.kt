package com.example.cocktailme.repository

import com.example.cocktailme.api.ApiHelper
import javax.inject.Inject

class CocktailRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getRandomCocktails() = apiHelper.getRandomCocktails()

}