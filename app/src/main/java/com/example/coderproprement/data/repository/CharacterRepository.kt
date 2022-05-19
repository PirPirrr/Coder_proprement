package com.example.coderproprement.data.repository

import fr.quentin.android3.model.Item

interface CharacterRepository {
    suspend fun getPaginatedCharacter(): Item

    suspend fun getCharacter(id: String): Item
}