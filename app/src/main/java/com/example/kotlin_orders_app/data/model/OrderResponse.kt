package com.example.kotlin_orders_app.data.model

import com.google.gson.annotations.SerializedName

class OrderResponse (
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("data")
    val data: OrderData,
)

