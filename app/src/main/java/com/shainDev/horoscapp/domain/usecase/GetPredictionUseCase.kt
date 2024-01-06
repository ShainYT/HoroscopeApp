package com.shainDev.horoscapp.domain.usecase

import com.shainDev.horoscapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    //Operator permite sobreescribir cosas
    suspend operator fun invoke(sign: String) =
        repository.getPrediction(sign)


}