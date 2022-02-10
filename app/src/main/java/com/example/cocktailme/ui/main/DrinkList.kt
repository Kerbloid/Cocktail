package com.example.cocktailme.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.cocktailme.model.Drink

@Composable
fun DrinkList(cocktails: List<Drink>, navigateToDrink: (Drink) -> Unit) {
    LazyColumn {
        items(cocktails) {
            DrinkListItem(drink = it, navigateToDrink)
        }
    }
}