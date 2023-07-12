package com.example.kotlin_orders_app.data.api

import com.example.kotlin_orders_app.data.model.OrderResponse
import retrofit2.http.GET

//TODO: how this interface work under the hood
interface OrderService {
    //mock service entry
    @GET("50ebf6fa-742b-420b-b18b-13e57df9dd14")
    suspend fun getOrders(): OrderResponse
}