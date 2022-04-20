package com.example.newproject.util

import com.example.newproject.model.service.NetworkService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()

            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl("https://www.dhlottery.co.kr")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }


        val api by lazy {
            retrofit.create(NetworkService::class.java)
        }
    }
}