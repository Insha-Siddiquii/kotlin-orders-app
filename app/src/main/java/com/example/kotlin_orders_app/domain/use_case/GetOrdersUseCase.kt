package com.example.kotlin_orders_app.domain.use_case

import com.example.kotlin_orders_app.data.model.OrderResponse
import kotlinx.coroutines.flow.Flow

interface GetOrdersUseCase {
    fun fetchOrders(): Flow<OrderResponse>
}