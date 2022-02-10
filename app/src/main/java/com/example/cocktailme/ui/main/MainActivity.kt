package com.example.cocktailme.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cocktailme.model.Drink
import com.example.cocktailme.viewmodel.CocktailViewModel
import com.example.cocktailme.theme.DrinkTheme
import com.example.cocktailme.ui.components.CircularIndeterminateProgressBar
import com.example.cocktailme.ui.drinkInfo.DrinkActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CocktailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrinkTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        ContentMain {
                            startActivity(DrinkActivity.newIntent(this@MainActivity, it))
                        }
                        CircularIndeterminateProgressBar(isDisplayed = viewModel.loading.value)
                    }
                }
            }
        }
    }

    @Composable
    fun ContentMain(navigateToDrink: (Drink) -> Unit) {
        DrinkList(viewModel.cocktails, navigateToDrink = navigateToDrink)
    }

    companion object {
        const val TAG = "b_MainActivity"
    }
}