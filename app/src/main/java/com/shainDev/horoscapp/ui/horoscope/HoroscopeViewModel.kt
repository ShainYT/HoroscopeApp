package com.shainDev.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.shainDev.horoscapp.data.providers.HoroscopeProvider
import com.shainDev.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) :
    ViewModel() {

    //Esta es para que pueda cambiar pero no fuera del viewmodel
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())

    //Este es para que pueda leer los demas sin modificar
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value =
            horoscopeProvider.getHoroscopes()

    }


}