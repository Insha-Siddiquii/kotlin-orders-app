package com.example.kotlin_orders_app.di

import com.example.kotlin_orders_app.data.api.OrderService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Declare dependencies of app-level

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideOrderService(retrofit: Retrofit): OrderService =
    retrofit.create(OrderService::class.java)


val appModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), com.example.kotlin_orders_app.BuildConfig.BASE_URL) }
    //This could be only API-Service.
    //Currently app is only about OrderService, hence declaring it here.
    single { provideOrderService(retrofit = get()) }
}