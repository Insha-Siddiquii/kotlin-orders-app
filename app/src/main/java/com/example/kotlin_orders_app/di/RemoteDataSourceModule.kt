package com.example.kotlin_orders_app.di

import com.example.kotlin_orders_app.data.source.remote.GetOrdersRemoteDataSource
import com.example.kotlin_orders_app.data.source.remote.GetOrdersRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<GetOrdersRemoteDataSource> { GetOrdersRemoteDataSourceImpl(orderService = get()) }
}