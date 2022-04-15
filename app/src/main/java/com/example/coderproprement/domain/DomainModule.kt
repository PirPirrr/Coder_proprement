package com.example.coderproprement.domain

import org.koin.core.scope.get
import org.koin.dsl.module

object DomainModule {
    private val useCaseModule = module {
        factory {
            GetAllCharacterUseCase(get())
        }
    }

    val all = arrayOf(useCaseModule)
}