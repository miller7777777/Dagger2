package ru.levelp.dagger2.api

import io.reactivex.Single
import retrofit2.http.GET


interface CarService {

    @GET("1tW53X")
    fun cars(): Single<CarsResponse>
}