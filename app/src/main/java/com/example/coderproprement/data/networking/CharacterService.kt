package com.example.coderproprement.data.networking

import fr.quentin.android3.model.Item
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("v1/public/characters?limit=100")
    suspend fun getCharacters(): Item

    @GET("v1/public/characters/{id}?")
    suspend fun getCharacter(@Path("id") id: String): Item
}