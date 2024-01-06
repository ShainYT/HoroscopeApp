package com.shainDev.horoscapp.data.network

import com.shainDev.horoscapp.BuildConfig.BASE_URL
import com.shainDev.horoscapp.data.RepositoryImpl
import com.shainDev.horoscapp.data.core.interceptors.AuthInterceptor
import com.shainDev.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //Esto permite inyectar en el constructor un objeto de retrofit: Retrofit cuando empieza a buscar los modulos
    @Provides
    @Singleton //Es la creacion de una sola instancia como lo vimos en java
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    //Creacion de interceptor
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }


    // Esta funcion permite conectar el horoscopeApiService
    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiServicie {
        return retrofit.create(HoroscopeApiServicie::class.java)
    }

    //Esta permite poder llamarse con el caso de uso.

    @Provides
    fun provideRepository(apiServicie: HoroscopeApiServicie): Repository {
        return RepositoryImpl(apiServicie)
    }
}