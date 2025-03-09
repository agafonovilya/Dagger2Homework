package ru.otus.daggerhomework.producer

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.main.MainActivity

class ProducerFragment : Fragment(R.layout.fragment_producer) {

    private lateinit var producerComponent: ProducerComponent

    private val viewModel by viewModels<ProducerViewModel> {
        producerComponent.getProducerViewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        producerComponent = DaggerProducerComponent.factory()
            .create((activity as MainActivity).activityComponent)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
        producerComponent.inject(this)
    }
}