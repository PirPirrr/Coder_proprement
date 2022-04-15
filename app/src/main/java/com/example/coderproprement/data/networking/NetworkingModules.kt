package com.example.coderproprement.data.networking

import com.example.coderproprement.BuildConfig
import com.example.coderproprement.data.networking.interceptor.MarvelInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkingModules {
    private val okHttpClientModule = module {
        single {
            OkHttpClient.Builder()
                .addInterceptor(MarvelInterceptor())
                .build()
        }
    }

    private val retrofitModule = module{
        single {
            Retrofit.Builder()
                .client(get())
                .baseUrl(BuildConfig.WSUrl)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
        }
    }

    private val serviceModule = module {
        factory {
            get<Retrofit>().create(CharacterService::class.java)
        }
    }

    val all = arrayOf(
        okHttpClientModule,
        retrofitModule,
        serviceModule)
}

