package com.example.coderproprement.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coderproprement.domain.GetAllCharacterUseCase
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private var getAllCharacterUseCase: GetAllCharacterUseCase
) : ViewModel() {
    fun allCharacters(){
        viewModelScope.launch {
            getAllCharacterUseCase.invoke()
        }
    }
}