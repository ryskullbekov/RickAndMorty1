package com.example.rickandmorty.data.remote.apiService

import com.example.rickandmorty.data.remote.model.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("api/character/{id}")
    suspend fun fetchCharacterId(
        @Path("id") id: Int
    ): java.lang.Character

    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page:Int
    ): RickAndMortyResponse<java.lang.Character>
}