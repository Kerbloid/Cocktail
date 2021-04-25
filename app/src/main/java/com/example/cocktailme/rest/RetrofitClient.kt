package com.example.cocktailme.rest

import com.example.cocktailme.API_KEY
import com.example.cocktailme.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val service: CocktailService = Retrofit.Builder()
        .baseUrl("$BASE_URL$API_KEY/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .build()
        )
        .build()
        .create(CocktailService::class.java)
}