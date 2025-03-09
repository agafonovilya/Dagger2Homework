package ru.otus.daggerhomework.producer

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.main.ColorGenerator
import ru.otus.daggerhomework.main.ColorGeneratorImpl

@Module
interface ProducerModule {

    @ProducerScope
    @Binds
    fun provideColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}
