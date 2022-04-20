package com.example.animetrackerapp.core

import com.example.animetrackerapp.framework.networklayer.JikanApiClient
import com.example.animetrackerapp.utils.BASE_JIKAN_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private var retrofit: Retrofit? = null

    private fun provideRetrofit(): Retrofit {
        if (retrofit == null) {

            val builder = Retrofit.Builder()
                .baseUrl(BASE_JIKAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .writeTimeout(0, TimeUnit.MILLISECONDS)
                .readTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES).build()
            retrofit = builder.client(okHttpClient).build()
        }
        return retrofit!!
    }

    fun provideJikanService(): JikanApiClient {
        return provideRetrofit().create(JikanApiClient::class.java)
    }
}