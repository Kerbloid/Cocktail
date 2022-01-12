package com.example.cocktailme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailme.model.DrinkList
import com.example.cocktailme.repository.CocktailRepository
import com.example.cocktailme.utils.NetworkHelper
import com.example.cocktailme.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository,
    private val networkHelper: NetworkHelper
): ViewModel() {

    private val _randomCocktails = MutableLiveData<Resource<DrinkList>>()
    val randomCocktails: LiveData<Resource<DrinkList>>
        get() = _randomCocktails

    init {
        viewModelScope.launch {
            fetchCocktails()
        }
    }

    private suspend fun fetchCocktails() {
        viewModelScope.launch(Dispatchers.IO) {
            _randomCocktails.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                val response = cocktailRepository.getRandomCocktails().execute()
                cocktailRepository.getRandomCocktails().let {
                    if (response.isSuccessful) {
                        _randomCocktails.postValue(Resource.success(response.body()))
                    } else _randomCocktails.postValue(Resource.error(response.errorBody().toString(), null))
                }
            } else _randomCocktails.postValue(Resource.error("No internet connection", null))
        }
    }

}