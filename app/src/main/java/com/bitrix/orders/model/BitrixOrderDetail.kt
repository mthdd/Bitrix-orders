// com/bitrix/orders/model/BitrixOrderDetail.kt:
package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime


data class BitrixOrderDetail(
    @SerializedName("id") val id: String,
    @SerializedName("dateInsert") val date: String,
    @SerializedName("price") val totalPrice: Double,
    @SerializedName("currency") val currency: String,
    @SerializedName("statusXmlId") val status: String
) {
    fun toDomain(): Order = Order(
        id = id,
        title = "Заказ #$id",
        dateCreated = LocalDateTime.parse(date, formatter),
        totalPrice = totalPrice,
        currency = currency,
        statusCode = status
    )
}