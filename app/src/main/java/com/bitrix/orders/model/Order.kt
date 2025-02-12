// com/bitrix/orders/model/Order.kt:
package com.bitrix.orders.model

import java.time.LocalDateTime

data class Order(
    val id: String,
    val title: String,
    val dateCreated: LocalDateTime, // Используем LocalDateTime
    val totalPrice: Double,
    val currency: String,
    val statusCode: String
) {
    val statusText: String
        get() = OrderStatusMapper.getStatusText(statusCode)
}