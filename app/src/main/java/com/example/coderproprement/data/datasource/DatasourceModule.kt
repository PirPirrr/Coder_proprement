package com.example.coderproprement.data.datasource

import org.koin.core.scope.get
import org.koin.dsl.module

object DatasourceModule {
    private val characterDatasource = module {
        single<CharacterRemoteDataSource> {
            CharacterRemoteDataSourceImpl(get())
        }
    }

    val all = arrayOf(characterDatasource)
}