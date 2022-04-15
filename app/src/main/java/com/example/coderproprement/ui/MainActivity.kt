package com.example.coderproprement.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coderproprement.R
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}