package com.example.coderproprement.data.networking.interceptor

import com.example.coderproprement.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

class MarvelInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()
        val ts = Date().toString()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("ts", ts)
            .addQueryParameter("apikey", BuildConfig.MARVEL_PUBLIC_API_KEY)
            .addQueryParameter(
                "hash",
                ("$ts${BuildConfig.MARVEL_PRIVATE_API_KEY}${BuildConfig.MARVEL_PUBLIC_API_KEY}").md5()
            )
            .build()
        println(url.toString())
        val requestBuilder = original.newBuilder()
            .url(url)
            .build()
        return chain.proceed(requestBuilder)
    }
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(this.toByteArray())).toString(16).padStart(32, '0')
}