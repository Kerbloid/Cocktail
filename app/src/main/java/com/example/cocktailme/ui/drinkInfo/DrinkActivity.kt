package com.example.cocktailme.ui.drinkInfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktailme.model.Drink
import com.example.cocktailme.theme.CocktailMeTheme

class DrinkActivity : AppCompatActivity() {
    private val drink: Drink by lazy {
        intent?.getSerializableExtra(DRINK) as Drink
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailMeTheme {
                DrinkScreen(drink)
            }
        }
    }

    companion object {
        private const val DRINK = "drink"
        fun newIntent(context: Context, drink: Drink) =
            Intent(context, DrinkActivity::class.java).apply {
                putExtra(DRINK, drink)
            }
    }
}