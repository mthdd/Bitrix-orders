// com/bitrix/orders/model/Order.kt:
package com.bitrix.orders.model

data class Order(
    val id: String,
    val title: String,
    val dateCreated: String,
    val totalPrice: Double,
    val currency: String,
    val status: String
){
    fun toDomain(): Order {
        return Order(
            id = id,
            title = "Заказ #$id",
            dateCreated = dateCreated,
            totalPrice = totalPrice,
            currency = currency,
            status = status
        )
    }
}