// network/BitrixApiService.kt
package com.bitrix.orders.network

import com.bitrix.orders.model.Order
import retrofit2.http.GET
import retrofit2.http.Path

interface BitrixApiService {
    @GET("orders") // Замените на реальный эндпоинт Bitrix
    suspend fun getOrders(): List<Order>

    @GET("orders/{id}") // Эндпоинт для деталей заказа
    suspend fun getOrderDetails(
        @Path("id") orderId: String // Параметр пути
    ): Order
}

