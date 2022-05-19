package com.example.coderproprement.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coderproprement.domain.GetAllCharacterUseCase
import fr.quentin.android3.model.Item
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private var getAllCharacterUseCase: GetAllCharacterUseCase
) : ViewModel() {
    var idCharacter = ""

    fun allCharacters(): MutableLiveData<Item>{
        val listItem = MutableLiveData<Item>()
        viewModelScope.launch {
            listItem.postValue(getAllCharacterUseCase.invoke())
        }
        return listItem
    }

}