package com.example.rickandmorty.di

import com.example.rickandmorty.data.remote.apiService.ApiService
import com.example.rickandmorty.data.remote.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Provides
    @Singleton
    fun provideApiService(): ApiService = retrofitClient
        .provideApiService()
}