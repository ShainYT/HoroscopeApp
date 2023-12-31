package com.shainDev.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs

import com.shainDev.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.shainDev.horoscapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args:HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}