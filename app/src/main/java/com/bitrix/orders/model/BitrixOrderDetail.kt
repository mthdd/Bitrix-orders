// com/bitrix/orders/model/BitrixOrderDetail.kt:
package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName
// import com.bitrix.orders.model.Order

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
        dateCreated = date,
        totalPrice = totalPrice,
        currency = currency,
        status = status
    )
}