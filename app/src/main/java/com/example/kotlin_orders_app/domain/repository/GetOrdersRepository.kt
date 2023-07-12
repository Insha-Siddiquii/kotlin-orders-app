package com.example.kotlin_orders_app.domain.repository

import com.example.kotlin_orders_app.data.model.OrderResponse
import kotlinx.coroutines.flow.Flow

interface GetOrdersRepository {
    fun fetchOrders(): Flow<OrderResponse>
}