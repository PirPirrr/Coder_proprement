package com.example.coderproprement.domain

import android.util.Log
import com.example.coderproprement.data.repository.CharacterRepository
import fr.quentin.android3.model.Item

class GetAllCharacterUseCase(
    private var characterRepository: CharacterRepository
) {
    suspend operator fun invoke() : Item {
        return characterRepository.getPaginatedCharacter()
    }
}