package com.example.coderproprement.ui

import android.app.Application
import com.example.coderproprement.data.datasource.DatasourceModule
import com.example.coderproprement.data.networking.NetworkingModules
import com.example.coderproprement.data.repository.RepositoryModule
import com.example.coderproprement.domain.DomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(*UIModule.all,*DomainModule.all,*RepositoryModule.all,*DatasourceModule.all,*NetworkingModules.all)
        }
    }
}