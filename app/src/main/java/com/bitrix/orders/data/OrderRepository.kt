// com/bitrix/orders/data/OrderRepository.kt
package com.bitrix.orders.data

import com.bitrix.orders.model.BitrixOrder
import com.bitrix.orders.model.BitrixOrderDetail
import com.bitrix.orders.model.Order
import com.bitrix.orders.network.BitrixApiService
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val apiService: BitrixApiService
) {
    suspend fun getOrders(): List<Order> {
        val response = apiService.getOrders(
            webhookId = "1",
            webhookKey = "90fr03z5z99ecggz"
        )
        return if (response.isSuccessful) {
            response.body()?.result?.orders?.map { it.toDomain() } ?: emptyList()
        } else {
            emptyList()
        }
    }

    suspend fun getOrderDetails(orderId: String): BitrixOrderDetail {
        val response = apiService.getOrderDetails(
            webhookId = "1",
            webhookKey = "90fr03z5z99ecggz",
            orderId = orderId
        )
        return if (response.isSuccessful) {
            response.body()?.result?.order ?: throw Exception("Order not found")
        } else {
            throw Exception("Failed to fetch order details")
        }
    }
}