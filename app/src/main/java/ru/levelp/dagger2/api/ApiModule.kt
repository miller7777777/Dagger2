package ru.levelp.dagger2.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@Singleton
class ApiModule {
    val api = "https://goo.gl/1tW53X"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()

    @Provides
    @Singleton
    fun provideCarService(retrofit: Retrofit): CarService = retrofit.create(CarService::class.java)

    private companion object {
        const val BASE_URL = "https://goo.gl/"
    }
}