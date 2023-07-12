package com.example.kotlin_orders_app.di

import com.example.kotlin_orders_app.ui.view_model.OrderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        OrderViewModel(orderUseCase = get())
    }
}