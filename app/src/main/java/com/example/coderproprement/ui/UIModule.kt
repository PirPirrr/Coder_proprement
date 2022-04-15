package com.example.coderproprement.ui

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModule {
    private val characterListModule = module {
        viewModel {
            CharacterListViewModel(get())
        }

    }
    val all = arrayOf(characterListModule)
}