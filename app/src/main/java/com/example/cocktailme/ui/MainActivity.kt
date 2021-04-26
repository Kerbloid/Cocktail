package com.example.cocktailme.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktailme.R
import com.example.cocktailme.model.Drink
import com.example.cocktailme.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: CocktailAdapter
    private var drinkList = listOf<Drink>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        get.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                drinkList = viewModel.getPopularCocktails()!!
                lifecycleScope.launch {
                    linearLayoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.layoutManager = linearLayoutManager
                    adapter = CocktailAdapter(drinkList)
                    recyclerView.adapter = adapter
                    recyclerView.addItemDecoration(DividerItemDecoration(
                        recyclerView.context,
                        linearLayoutManager.orientation
                    ))
                }
            }
        }
    }

    companion object {
        const val TAG = "b_MainActivity"
    }
}