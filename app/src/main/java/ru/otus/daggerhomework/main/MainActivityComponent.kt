package ru.otus.daggerhomework.main

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.ApplicationContext

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainModule::class]
)
interface MainActivityComponent {
    fun getColorStateObserver(): ColorStateObserver

    @ActivityContext
    fun getActivityContext(): Context

    @ApplicationContext
    fun getApplicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }
}
