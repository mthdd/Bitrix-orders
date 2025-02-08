package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName
import java.util.Date

// Основная модель заказа
data class Order(
    @SerializedName("ID")
    val id: String,

    @SerializedName("TITLE")
    val title: String,

    @SerializedName("DATE_CREATE")
    val dateCreated: Date,

    @SerializedName("STATUS_ID")
    val status: String,

    @SerializedName("PRICE")
    val totalPrice: Double,

    @SerializedName("CURRENCY")
    val currency: String,

    @SerializedName("ITEMS")
    val items: List<OrderItem> = emptyList(),

    @SerializedName("CLIENT")
    val client: Client? = null
)

// Модель позиции в заказе
data class OrderItem(
    @SerializedName("PRODUCT_ID")
    val productId: String,

    @SerializedName("NAME")
    val name: String,

    @SerializedName("QUANTITY")
    val quantity: Int,

    @SerializedName("PRICE")
    val price: Double
)

// Модель клиента
data class Client(
    @SerializedName("NAME")
    val name: String,

    @SerializedName("PHONE")
    val phone: String,

    @SerializedName("EMAIL")
    val email: String?
)

// Статусы заказов (адаптируйте под ваши статусы в Bitrix)
enum class OrderStatus(val displayName: String) {
    @SerializedName("NEW")
    NEW("Новый заказ"),

    @SerializedName("PROCESSING")
    PROCESSING("В обработке"),

    @SerializedName("SHIPPED")
    SHIPPED("Отправлен"),

    @SerializedName("COMPLETED")
    COMPLETED("Завершен"),

    @SerializedName("CANCELLED")
    CANCELLED("Отменен")
}