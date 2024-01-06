package com.shainDev.horoscapp.domain

import com.shainDev.horoscapp.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sign: String): PredictionModel?


}