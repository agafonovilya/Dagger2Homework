package ru.otus.daggerhomework.main

import android.graphics.Color
import androidx.annotation.ColorInt
import javax.inject.Inject
import kotlin.random.Random

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}

class ColorGeneratorImpl @Inject constructor() : ColorGenerator {

    @ColorInt
    override fun generateColor(): Int {
        return Color.argb(
            255,
            Random.nextInt(0, 255),
            Random.nextInt(0, 255),
            Random.nextInt(0, 255)
        )
    }
}
