package com.example.coderproprement.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coderproprement.domain.GetCharacterDetailsUseCase
import fr.quentin.android3.model.Item
import kotlinx.coroutines.launch

class DetailCharacterViewModel(
    private var getCharacterDetailsUseCase: GetCharacterDetailsUseCase
) : ViewModel() {
    fun Character(id: String): MutableLiveData<Item>{
        val item = MutableLiveData<Item>()
        viewModelScope.launch {
            item.postValue(getCharacterDetailsUseCase.invoke(id))

        }
        return item
    }
}