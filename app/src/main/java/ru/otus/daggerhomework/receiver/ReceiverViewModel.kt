package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ApplicationContext
import ru.otus.daggerhomework.main.ColorStateObserver
import javax.inject.Inject

class ReceiverViewModel(
    private val colorStateObserver: ColorStateObserver,
    private val context: Context
) : ViewModel() {

    private val _colorState = MutableStateFlow(Color.WHITE)
    val colorState = _colorState.asStateFlow()

    init {
        Log.d("TAGTAG", "init: $colorStateObserver")

        observeColors()
    }

    private fun observeColors() {
        viewModelScope.launch {
            colorStateObserver.state.collect {
                if (context !is Application) throw RuntimeException("Application context is required")
                _colorState.emit(it)
                Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

class ReceiverViewModelFactory @Inject constructor(
    private val colorStateObserver: ColorStateObserver,
    @ApplicationContext private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ReceiverViewModel(colorStateObserver, context) as T
    }
}
