package ru.levelp.dagger2

import dagger.Component
import ru.levelp.dagger2.api.ApiModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {

    fun  inject(mainActivity: MainActivity) {}
}