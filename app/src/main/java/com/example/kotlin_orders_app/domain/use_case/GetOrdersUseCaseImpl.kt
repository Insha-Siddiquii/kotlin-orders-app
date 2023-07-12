package com.example.kotlin_orders_app.domain.use_case

import com.example.kotlin_orders_app.data.model.OrderResponse
import com.example.kotlin_orders_app.domain.repository.GetOrdersRepository
import kotlinx.coroutines.flow.Flow

class GetOrdersUseCaseImpl(
    private val getOrderRepository: GetOrdersRepository
) : GetOrdersUseCase {
    override fun fetchOrders(): Flow<OrderResponse> {
        return getOrderRepository.fetchOrders()
    }
}