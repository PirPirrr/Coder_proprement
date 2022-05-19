package com.example.coderproprement.data.datasource

import com.example.coderproprement.data.networking.CharacterService
import fr.quentin.android3.model.Item

class CharacterRemoteDataSourceImpl(
    private var characterService: CharacterService
): CharacterRemoteDataSource {
    override suspend fun getAllCharacter(): Item {
        return characterService.getCharacters()
    }

    override  suspend fun getCharacter(id: String): Item{
        return characterService.getCharacter(id)
    }

}