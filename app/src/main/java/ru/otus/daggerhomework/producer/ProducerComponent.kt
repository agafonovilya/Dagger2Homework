package ru.otus.daggerhomework.producer

import dagger.Component
import ru.otus.daggerhomework.main.MainActivityComponent

@ProducerScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ProducerModule::class]
)
interface ProducerComponent {

    fun getProducerViewModelFactory(): ProducerViewModelFactory

    fun inject(fragment: ProducerFragment)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): ProducerComponent
    }
}
