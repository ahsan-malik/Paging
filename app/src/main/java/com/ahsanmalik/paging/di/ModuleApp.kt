package com.ahsanmalik.paging.di

import com.ahsanmalik.paging.db.remote.MyApi
import com.ahsanmalik.paging.others.Helper
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
class ModuleApp {

    @Provides
    @Singleton
    fun apiService() = Retrofit.Builder()
        .baseUrl(Helper.BASE_URL)
        .client(OkHttpClient.Builder().also { client ->
            client.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }.build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MyApi::class.java)!!

}