package com.example.kotlin_orders_app.di

import com.example.kotlin_orders_app.domain.use_case.GetOrdersUseCase
import com.example.kotlin_orders_app.domain.use_case.GetOrdersUseCaseImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
    single<GetOrdersUseCase> {GetOrdersUseCaseImpl(getOrderRepository = get())}
}