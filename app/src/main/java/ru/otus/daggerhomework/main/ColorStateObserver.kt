package ru.otus.daggerhomework.main

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ColorStateObserver {
    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    suspend fun emitColor(@ColorInt int: Int) {
        _state.emit(int)
    }
}
