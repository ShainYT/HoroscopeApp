package com.shainDev.horoscapp.data.core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //Chain es la peticion de retrofit
        val request = chain.request()
            .newBuilder()//En esta parte le dice que se vuelva a crear con los datos que tiene
            .header("Autorization", tokenManager.getToken())//Y le agrega mas
            .build() //Y se vuelve a procesar
        return chain.proceed(request) //Aqui dice que continue con lo que hace siempre.
    }

}

class TokenManager @Inject constructor() {
    fun getToken(): String = "LEARN"
}