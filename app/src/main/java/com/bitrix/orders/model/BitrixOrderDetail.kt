package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName
// import com.bitrix.orders.model.Order

data class BitrixOrderDetail(
    @SerializedName("ID") val id: String,
    @SerializedName("DATE_INSERT") val date: String,
    @SerializedName("PRICE") val totalPrice: Double,
    @SerializedName("CURRENCY") val currency: String,
    @SerializedName("STATUS_ID") val status: String
) {
    fun toDomain(): Order = Order(
        id = id,
        title = "Заказ #$id",
        dateCreated = date,
        totalPrice = totalPrice,
        currency = currency,
        status = status
    )
}