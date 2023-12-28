package com.shainDev.horoscapp.data.providers

import com.shainDev.horoscapp.domain.model.HoroscopeInfo
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Aquarius
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Aries
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Cancer
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Capricorn
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Gemini
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Leo
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Libra
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Pisces
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Sagittarius
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Scorpio
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Taurus
import com.shainDev.horoscapp.domain.model.HoroscopeInfo.Virgo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }

}