// data/OrderRepository.kt
package com.bitrix.orders.data

import com.bitrix.orders.model.Order
import com.bitrix.orders.network.BitrixApiService
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val apiService: BitrixApiService
) {
    suspend fun getOrders(): List<Order> {
        return apiService.getOrders() // ✅
    }

    suspend fun getOrderDetails(orderId: String): Order {
        return apiService.getOrderDetails(orderId) // Теперь должно работать
    }
}