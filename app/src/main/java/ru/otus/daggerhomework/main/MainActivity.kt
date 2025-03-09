package ru.otus.daggerhomework.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.producer.ProducerFragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.receiver.ReceiverFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerMainActivityComponent
            .factory()
            .create((application as App).appComponent, this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.topFragment, ProducerFragment())
            .replace(R.id.bottomFragment, ReceiverFragment())
            .commit()
    }
}
