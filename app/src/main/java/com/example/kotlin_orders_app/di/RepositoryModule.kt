package com.example.kotlin_orders_app.di

import com.example.kotlin_orders_app.data.repository.GetOrdersRepositoryImpl
import com.example.kotlin_orders_app.domain.repository.GetOrdersRepository
import org.koin.dsl.module

val repoModule = module {
    single<GetOrdersRepository> { GetOrdersRepositoryImpl(getOrdersRemoteDataSource = get()) }
}