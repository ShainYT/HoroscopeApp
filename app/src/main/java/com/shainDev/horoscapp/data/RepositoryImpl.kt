package com.shainDev.horoscapp.data

import android.util.Log
import com.shainDev.horoscapp.data.network.HoroscopeApiServicie
import com.shainDev.horoscapp.domain.Repository
import com.shainDev.horoscapp.domain.model.PredictionModel
import javax.inject.Inject
//Una vez declarada la funcion dentro de los modulos puedo inyectar el apiservice
class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiServicie) :
    Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        //Peticion Retrofit
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess {
                return it.toDomain()
            }.onFailure {
                Log.i("Alvaro", "Ha ocurrido un error: ${it.message}")
            }
        return null
    }
}