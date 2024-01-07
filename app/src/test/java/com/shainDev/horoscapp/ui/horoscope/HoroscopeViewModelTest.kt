package com.shainDev.horoscapp.ui.horoscope

import com.shainDev.horoscapp.data.providers.HoroscopeProvider
import com.shainDev.horoscapp.motherobject.HoroscopeMotherObject.horoscopeInfoList

import io.mockk.MockKAnnotations.init
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue


class HoroscopeViewModelTest {
    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before //Se ejecuta antes del test
    fun setUp() {
        init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscopes are loaded`() {
        //CORUTINAS coevery
        every { horoscopeProvider.getHoroscopes() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopes = viewModel.horoscope.value
        assertTrue(horoscopes.isNotEmpty())

    }

}