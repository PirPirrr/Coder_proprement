package com.example.coderproprement.domain

import com.example.coderproprement.data.repository.CharacterRepository
import fr.quentin.android3.model.Item

class GetCharacterDetailsUseCase(
    private var characterRepository: CharacterRepository
) {
    suspend operator fun invoke(id: String) : Item {
        return characterRepository.getCharacter(id)
    }
}