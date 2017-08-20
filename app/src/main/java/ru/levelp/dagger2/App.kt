package ru.levelp.dagger2

import android.app.Application


class App : Application() {

    lateinit var appComponent: AppComponent
    private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }



}