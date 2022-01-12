package com.example.cocktailme.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.cocktailme.R
import com.example.cocktailme.model.Drink
import com.example.cocktailme.model.DrinkList
import com.example.cocktailme.utils.Status
import com.example.cocktailme.viewmodel.CocktailViewModel
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CocktailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                DrinkList(viewModel.cocktails)
                CircularProgressIndicator()
            }
        }
    }

    @Composable
    fun DrinkItem(drink: Drink) {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            GlideImage(
                imageModel = drink.strDrinkThumb,
                contentScale = ContentScale.Crop,
                circularReveal = CircularReveal(duration = 250),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clip(CircleShape)
                    .size(50.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // We toggle the isExpanded variable when we click on this Column

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = drink.strDrink!!,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2,
                    softWrap = false
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = drink.strAlcoholic!!,
//                color = Color.White,
                    style = MaterialTheme.typography.body2,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Divider(color = Color.Gray, thickness = 1.dp, startIndent = 66.dp)
    }

    @Composable
    fun DrinkList(drinks: List<Drink>) {
        LazyColumn {
            items(drinks) {
                DrinkItem(drink = it)
            }
        }
    }

    companion object {
        const val TAG = "b_MainActivity"
    }
}