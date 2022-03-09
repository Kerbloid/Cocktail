package com.example.cocktailme.ui.drinkInfo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cocktailme.model.Drink

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

        Spacer(modifier = Modifier.height(8.dp))
        
        DrinkIngredients(drink = drink)

        Spacer(modifier = Modifier.height(8.dp))

        DrinkInstructions(instructions = drink.strInstructions!!)
        // Add a spacer that always shows part (55.dp) of the fields list regardless of the device,
        // in order to always leave some content at the top.
        Spacer(Modifier.height((containerHeight - 380.dp).coerceAtLeast(0.dp)))
    }
}

