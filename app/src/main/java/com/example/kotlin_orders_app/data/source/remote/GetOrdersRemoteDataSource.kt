package com.example.kotlin_orders_app.data.source.remote

import com.example.kotlin_orders_app.data.model.OrderResponse
import kotlinx.coroutines.flow.Flow

interface GetOrdersRemoteDataSource {
    fun fetchOrders(): Flow<OrderResponse>
}