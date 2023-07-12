package com.example.kotlin_orders_app.ui.view_model

import com.example.kotlin_orders_app.data.model.Order

//
//sealed class OrderUiState<T>(
//    val orders: List<Order>? = null,
//    val message: String? = "",
//    val status: Boolean? = false
//) {
//    class Success<T>(orders: List<Order>?) : OrderUiState<T>(orders = orders)
//    class Error<T>(errorMessage: String) : OrderUiState<T>(message = errorMessage)
//    class Loading<T>() : OrderUiState<T>()
//}


sealed class OrderUiState {
    data class Success(val orders: List<Order>) : OrderUiState()
    data class Error(val errorMessage: String) : OrderUiState()
    data class Loading(val isLoading: Boolean) : OrderUiState()
}