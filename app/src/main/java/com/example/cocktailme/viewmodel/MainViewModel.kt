package com.example.cocktailme.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cocktailme.model.Drink
import com.example.cocktailme.repository.CocktailRepository

class MainViewModel: ViewModel() {

    suspend fun getRandomCocktail(): List<Drink>? {
        return CocktailRepository.getRandomCocktail()
    }

    suspend fun getPopularCocktails(): List<Drink>? {
        return CocktailRepository.getPopularCocktails()
    }
}