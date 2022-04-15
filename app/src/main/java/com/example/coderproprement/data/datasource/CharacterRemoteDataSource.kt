package com.example.coderproprement.data.datasource

import fr.quentin.android3.model.Item

interface CharacterRemoteDataSource {
    suspend fun getAllCharacter(): Item
}