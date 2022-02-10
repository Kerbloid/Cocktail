package com.example.cocktailme.ui.drinkInfo

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.example.cocktailme.model.Drink
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DrinkHeaderImage(
    scrollState: ScrollState,
    drink: Drink,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    GlideImage(
        imageModel = drink.strDrinkThumb,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp)
    )
}