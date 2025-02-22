package ru.otus.daggerhomework.main

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ApplicationComponent

@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance context: Context
        ): MainActivityComponent
    }
}
