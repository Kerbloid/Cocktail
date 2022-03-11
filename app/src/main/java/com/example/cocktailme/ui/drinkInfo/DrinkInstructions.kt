package com.example.cocktailme.ui.drinkInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrinkInstructions(instructions: String?) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Text(
            text = instructions ?: "",
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun DrinkInstructionsPreview() {
    DrinkInstructions(instructions = "As with most cocktails, crafting mojitos requires a few special tools — namely, a muddler. " +
            "This bartending tool is used to crush fresh herbs and fruits to help release their flavors. " +
            "If you don't have a muddler, use the end of a wooden spoon instead. ")
}