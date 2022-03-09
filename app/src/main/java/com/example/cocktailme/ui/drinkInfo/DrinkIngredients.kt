package com.example.cocktailme.ui.drinkInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cocktailme.model.Drink

@Composable
fun DrinkIngredients(drink: Drink) {
    Column(modifier = Modifier.padding(start = 16.dp)) {
        Row() {
            if (!drink.strIngredient1.isNullOrEmpty()) {
                Text(text = drink.strIngredient1, modifier = Modifier.padding(end = 20.dp))
                if (!drink.strMeasure1.isNullOrEmpty()) {
                    Text(text = drink.strMeasure1)
                }
            }
        }
        Row() {
            if (!drink.strIngredient2.isNullOrEmpty()) {
                Text(text = drink.strIngredient2, modifier = Modifier.padding(end = 20.dp))
                if (!drink.strMeasure2.isNullOrEmpty()) {
                    Text(text = drink.strMeasure2)
                }
            }
        }
        Row() {
            if (!drink.strIngredient3.isNullOrEmpty()) {
                Text(text = drink.strIngredient3, modifier = Modifier.padding(end = 20.dp))
                if (!drink.strMeasure3.isNullOrEmpty()) {
                    Text(text = drink.strMeasure3)
                }
            }
        }
        Row() {
            if (drink.strIngredient4 != null) {
                Text(text = drink.strIngredient4.toString(), modifier = Modifier.padding(end = 20.dp))
                if (drink.strMeasure5 != null) {
                    Text(text = drink.strMeasure4.toString())
                }
            }
        }
        Row() {
            if (drink.strIngredient5 != null) {
                Text(text = drink.strIngredient5.toString(), modifier = Modifier.padding(end = 20.dp))
                if (drink.strMeasure5 != null) {
                    Text(text = drink.strMeasure5.toString())
                }
            }
        }
        Row() {
            if (drink.strIngredient6 != null) {
                Text(text = drink.strIngredient6.toString(), modifier = Modifier.padding(end = 20.dp))
                if (drink.strMeasure6 != null) {
                    Text(text = drink.strMeasure6.toString())
                }
            }
        }
        Row() {
            if (drink.strIngredient7 != null) {
                Text(text = drink.strIngredient7.toString(), modifier = Modifier.padding(end = 20.dp))
                if (drink.strMeasure7 != null) {
                    Text(text = drink.strMeasure7.toString())
                }
            }
        }
        Row() {
            if (drink.strIngredient8 != null) {
                Text(text = drink.strIngredient8.toString(), modifier = Modifier.padding(end = 20.dp))
                if (drink.strMeasure8 != null) {
                    Text(text = drink.strMeasure8.toString())
                }
            }
        }
        Row() {
            if (drink.strIngredient9 != null) {
                Text(text = drink.strIngredient9.toString(), modifier = Modifier.padding(end = 20.dp))
                if (drink.strMeasure9 != null) {
                    Text(text = drink.strMeasure9.toString())
                }
            }
        }
    }
}