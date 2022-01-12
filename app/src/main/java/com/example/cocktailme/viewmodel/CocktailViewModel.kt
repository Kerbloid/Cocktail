package com.example.cocktailme.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailme.model.Drink
import com.example.cocktailme.model.DrinkList
import com.example.cocktailme.repository.CocktailRepository
import com.example.cocktailme.utils.NetworkHelper
import com.example.cocktailme.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    var cocktails by mutableStateOf(listOf<Drink>()) // could be val as well
        private set

    init {
        viewModelScope.launch {
            cocktails = fetchCocktails()!!
        }
    }

    private suspend fun fetchCocktails(): List<Drink>? = withContext(Dispatchers.IO) {
        cocktailRepository.getRandomCocktails().drinks
//        Log.d("SASA", "start fetch")
//        viewModelScope.launch(Dispatchers.IO) {
//            _randomCocktails.postValue(null)
//            if (networkHelper.isNetworkConnected()) {
//                cocktailRepository.getRandomCocktails().let {
//                    _randomCocktails.postValue(cocktailRepository.getRandomCocktails())
//                }
//            } else _randomCocktails.postValue(null)
//        }
    }

}