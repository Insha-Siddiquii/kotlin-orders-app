package com.example.kotlin_orders_app.data.model

import com.google.gson.annotations.SerializedName

class OrderData (
    @SerializedName("orders")
    val orders: List<Order> = ArrayList(),
)