package com.example.kotlin_orders_app.data.source.remote

import com.example.kotlin_orders_app.data.api.OrderService
import com.example.kotlin_orders_app.data.model.OrderResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class GetOrdersRemoteDataSourceImpl(private val orderService: OrderService) :
    GetOrdersRemoteDataSource {
    override fun fetchOrders(): Flow<OrderResponse> {
        return flow {
            emit(orderService.getOrders())
        }.flowOn(Dispatchers.IO)
            .map {
                it
            }
    }

}