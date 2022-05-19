package com.example.coderproprement.data.repository

import com.example.coderproprement.data.datasource.CharacterRemoteDataSource
import fr.quentin.android3.model.Item

class CharacterRepositoryImpl(
    private var characterRemoteDataSource: CharacterRemoteDataSource
): CharacterRepository {
    override suspend fun getPaginatedCharacter(): Item {
        return characterRemoteDataSource.getAllCharacter()
    }

    override suspend fun getCharacter(id: String): Item {
        return characterRemoteDataSource.getCharacter(id)
    }

}