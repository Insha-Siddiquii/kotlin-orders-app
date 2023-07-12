package com.example.kotlin_orders_app.data.model

import com.google.gson.annotations.SerializedName

//TODO: this is data layer model, must not be use in domain/use case layer

data class Order(
    @SerializedName("id")
    val id: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("dateTime")
    val dateTime: String,
)