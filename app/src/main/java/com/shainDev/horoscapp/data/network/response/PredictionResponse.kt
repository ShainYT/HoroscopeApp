package com.shainDev.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.shainDev.horoscapp.domain.model.PredictionModel

data class  PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String,
) {
    //Se crea esta funcion de PredictionModel debido a que si no lo hacemos el data y el domain se comunicarian lo cual no esta bien.
    fun toDomain(): PredictionModel =
        PredictionModel(horoscope = horoscope, sign = sign)

}