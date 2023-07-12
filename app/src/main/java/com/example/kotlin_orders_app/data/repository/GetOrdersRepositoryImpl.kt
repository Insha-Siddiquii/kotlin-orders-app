package com.example.kotlin_orders_app.data.repository

import com.example.kotlin_orders_app.data.model.OrderResponse
import com.example.kotlin_orders_app.data.source.remote.GetOrdersRemoteDataSource
import com.example.kotlin_orders_app.domain.repository.GetOrdersRepository
import kotlinx.coroutines.flow.Flow

class GetOrdersRepositoryImpl(private val getOrdersRemoteDataSource: GetOrdersRemoteDataSource) :
    GetOrdersRepository {
    override fun fetchOrders(): Flow<OrderResponse> {
        return getOrdersRemoteDataSource.fetchOrders()
    }
}