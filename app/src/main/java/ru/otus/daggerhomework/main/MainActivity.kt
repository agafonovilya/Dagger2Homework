package ru.otus.daggerhomework.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R

class MainActivity : ComponentActivity() {
    private lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerMainActivityComponent
            .factory()
            .create((application as App).appComponent, this)
        setContentView(R.layout.activity_main)
    }
}
