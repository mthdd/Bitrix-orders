package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName

data class BitrixOrder(
    @SerializedName("ID") val id: String,
    @SerializedName("DATE_INSERT") val date: String,
    @SerializedName("PRICE") val totalPrice: Double,
    @SerializedName("STATUS_ID") val status: String,
    val title: String,
    val currency: String
) {
    fun toDomain(): BitrixOrder {
        val currency: String = null.toString()
        return BitrixOrder(
            id = id,
            title = "Заказ #$id",
            date = date,
            totalPrice = totalPrice,
            currency = currency,
            status = status)
    }
}