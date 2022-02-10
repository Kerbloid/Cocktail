package com.example.cocktailme.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cocktailme.model.Drink
import com.example.cocktailme.ui.drinkInfo.DrinkHeaderImage
import com.example.cocktailme.ui.drinkInfo.DrinkName

@Composable
fun DrinkScreen(drink: Drink) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    DrinkHeaderImage(
                        scrollState,
                        drink,
                        this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(drink, this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
private fun ProfileContent(drink: Drink, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        DrinkName(drink)

        // Add a spacer that always shows part (55.dp) of the fields list regardless of the device,
        // in order to always leave some content at the top.
        Spacer(Modifier.height((containerHeight - 55.dp).coerceAtLeast(0.dp)))
    }
}

