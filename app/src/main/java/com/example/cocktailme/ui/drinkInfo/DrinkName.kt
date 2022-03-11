package com.example.cocktailme.ui.drinkInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cocktailme.model.Drink

@Composable
fun DrinkName(
    drinkName: String?
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Text(
            text = drinkName ?: "Empty",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }
}