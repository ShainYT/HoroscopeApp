package com.shainDev.horoscapp.data.network

import com.shainDev.horoscapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiServicie {

    @GET("/{sign}/")
    suspend fun getHoroscope(@Path("sign") sign: String): PredictionResponse

}
