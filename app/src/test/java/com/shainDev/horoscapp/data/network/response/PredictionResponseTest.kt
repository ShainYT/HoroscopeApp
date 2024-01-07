package com.shainDev.horoscapp.data.network.response


import com.shainDev.horoscapp.motherobject.HoroscopeMotherObject.anyResponse
import org.junit.Test
import io.kotlintest.shouldBe

class PredictionResponseTest {
    //Estas comillas solo se permiten en la capa de test unitario en android no deja.
    @Test
    fun `toDomain should return a correct PredictionModel`() {
        //Given (Informacion necesaria para test)
        val horoscopeResponse = anyResponse.copy(sign = "libra")

        //When (Que pase alguna circunstancia)
        val predictionModel = horoscopeResponse.toDomain()

        //Them (Verificar que ese algo sea lo esperado)
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}