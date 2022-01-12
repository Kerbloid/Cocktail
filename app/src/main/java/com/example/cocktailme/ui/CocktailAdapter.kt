package com.example.cocktailme.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktailme.R
import com.example.cocktailme.inflate
import com.example.cocktailme.model.Drink
import kotlinx.android.synthetic.main.item_cocktail.view.*

class CocktailAdapter(private val drinkList: ArrayList<Drink>): RecyclerView.Adapter<CocktailAdapter.CocktailHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CocktailHolder {
        val inflatedView = parent.inflate(R.layout.item_cocktail, false)
        return CocktailHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: CocktailHolder, position: Int) {
        val cocktail = drinkList[position]
        holder.bind(cocktail)
    }

    override fun getItemCount(): Int = drinkList.size

    class CocktailHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var cocktail: Drink? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
        }

        fun bind(cocktail: Drink) {
            this.cocktail = cocktail
            with(view) {
                with(cocktail) {
                    Glide.with(context).load(strDrinkThumb).into(cocktailImage)
                    cocktailName.text = strDrink
                    cocktailAlcohol.text = strAlcoholic
                }
            }
        }
    }

    fun addData(list: List<Drink>) {
        drinkList.addAll(list)
    }
}