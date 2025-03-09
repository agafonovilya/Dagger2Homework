package ru.otus.daggerhomework.producer

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.main.ColorGenerator
import ru.otus.daggerhomework.main.ActivityContext
import ru.otus.daggerhomework.main.ColorStateObserver
import javax.inject.Inject

class ProducerViewModel(
    private val colorGenerator: ColorGenerator,
    private val colorStateObserver: ColorStateObserver,
    private val context: Context
) : ViewModel() {

    fun generateColor() {
        Log.d("TAGTAG", "generateColor: $colorStateObserver")
        if (context !is Activity) throw RuntimeException("Activity context is required")
        viewModelScope.launch {
            colorStateObserver.emitColor(colorGenerator.generateColor())
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
    }
}

class ProducerViewModelFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val colorStateObserver: ColorStateObserver,
    @ActivityContext private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProducerViewModel(colorGenerator, colorStateObserver, context) as T
    }
}
