package com.bitrix.orders.model

// Основная модель заказа
data class Order(
    val id: String,
    val title: String,         // Добавлено
    val dateCreated: String,   // Переименовано с date
    val totalPrice: Double,
    val currency: String,      // Добавлено
    val status: String
){
    fun toDomain(): Order {
        return Order(
            id = id,
            title = "Заказ #$id",         // Генерируем title
            dateCreated = dateCreated,
            totalPrice = totalPrice,
            currency = currency,
            status = status
        )
    }
}