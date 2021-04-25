package com.example.cocktailme.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cocktailme.model.DrinkList
import com.example.cocktailme.repository.CocktailRepository

class MainViewModel: ViewModel() {

    suspend fun getRandomCocktail(): DrinkList? {
        return CocktailRepository.getRandomCocktail()
    }
}