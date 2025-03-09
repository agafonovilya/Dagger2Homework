package ru.otus.daggerhomework.main

import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
interface MainModule {
    companion object {
        @Provides
        @ActivityScope
        fun provideColorStateObserver(): ColorStateObserver = ColorStateObserver()
    }
}

@Qualifier
annotation class ActivityContext
