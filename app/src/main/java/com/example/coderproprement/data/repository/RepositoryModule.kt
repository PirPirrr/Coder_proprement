package com.example.coderproprement.data.repository

import org.koin.core.scope.get
import org.koin.dsl.module

object RepositoryModule {
    private val repositoryModule = module{
        single<CharacterRepository> {
            CharacterRepositoryImpl(get())
        }
    }

    val all = arrayOf(repositoryModule)
}