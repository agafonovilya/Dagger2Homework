package ru.otus.daggerhomework.receiver

import dagger.Component
import ru.otus.daggerhomework.main.MainActivityComponent

@ReceiverScope
@Component(dependencies = [MainActivityComponent::class])
interface ReceiverComponent {

    fun getReceiverViewModelFactory(): ReceiverViewModelFactory

    fun inject(fragment: ReceiverFragment)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): ReceiverComponent
    }
}
