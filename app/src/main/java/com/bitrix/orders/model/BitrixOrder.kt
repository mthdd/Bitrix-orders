// com/bitrix/orders/model/BitrixOrder.kt:
package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")

data class BitrixOrder(
    @SerializedName("id") val id: String,
    @SerializedName("dateInsert") val date: String,
    @SerializedName("price") val totalPrice: Double,
    @SerializedName("currency") val currency: String,
    @SerializedName("statusXmlId") val status: String
) {
    fun toDomain(): Order = Order(
        id = id,
        title = "Заказ #$id",
        dateCreated = LocalDateTime.parse(date, formatter), // Преобразование строки в LocalDateTime
        totalPrice = totalPrice,
        currency = currency,
        statusCode = status
    )
}

