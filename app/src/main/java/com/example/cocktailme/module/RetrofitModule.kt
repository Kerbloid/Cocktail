package com.example.cocktailme.module

import com.example.cocktailme.API_KEY
import com.example.cocktailme.BASE_URL
import com.example.cocktailme.BuildConfig
import com.example.cocktailme.api.ApiHelper
import com.example.cocktailme.api.ApiHelperImpl
import com.example.cocktailme.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

//    @Provides
//    fun provideBaseUrl() = "${BASE_URL}$API_KEY/"
    @Provides
    @Named("BASE_URL")
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Named("API_KEY")
    fun provideApiKey() = API_KEY

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        @Named("BASE_URL")
        BASE_URL: String,
        @Named("API_KEY")
        API_KEY: String
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("${BASE_URL}$API_KEY/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                okHttpClient
            )
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

}