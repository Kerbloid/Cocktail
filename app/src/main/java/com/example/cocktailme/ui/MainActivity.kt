package com.example.cocktailme.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.cocktailme.R
import com.example.cocktailme.model.DrinkList
import com.example.cocktailme.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        get.setOnClickListener {

            lifecycleScope.launch(Dispatchers.IO) {
                val drinkList: DrinkList? = viewModel.getRandomCocktail()
                if (drinkList != null) {
                    drinkList.drinks!!.forEach {
                        with(it) {
                            lifecycleScope.launch {
                                Glide.with(this@MainActivity)
                                    .load(strDrinkThumb)
                                    .into(cocktailImage)
                                cocktailName.text = strDrink
                                cocktailAlcohol.text = strAlcoholic
                            }
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val TAG = "b_MainActivity"
    }
}