package ru.otus.daggerhomework.receiver

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.main.MainActivity

class ReceiverFragment : Fragment(R.layout.fragment_receiver) {

    private lateinit var receiverComponent: ReceiverComponent

    private val viewModel by viewModels<ReceiverViewModel> {
        receiverComponent.getReceiverViewModelFactory()
    }

    private lateinit var frame: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receiverComponent =
            DaggerReceiverComponent.factory().create((activity as MainActivity).activityComponent)
        receiverComponent.inject(this)
        frame = view.findViewById(R.id.frame)

        lifecycleScope.launch {
            viewModel.colorState.collect {
                populateColor(it)
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}
