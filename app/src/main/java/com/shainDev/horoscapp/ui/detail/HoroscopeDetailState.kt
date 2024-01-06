package com.shainDev.horoscapp.ui.detail

import com.shainDev.horoscapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    //Cuando requiere parametros en un dataclass si no es un object
    data object Loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Sucess(
        val prediction: String,
        val sign: String,
        val horoscopeModel: HoroscopeModel
    ) : HoroscopeDetailState()


}