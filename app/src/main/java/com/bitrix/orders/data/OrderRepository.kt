// data/OrderRepository.kt
package com.bitrix.orders.data

import com.bitrix.orders.model.BitrixOrder
import com.bitrix.orders.model.BitrixOrderDetail
import com.bitrix.orders.network.BitrixApiService
import javax.inject.Inject
import com.google.gson.annotations.SerializedName

data class BitrixOrderResponse(
    @SerializedName("result") val orders: List<BitrixOrder>
)

class OrderRepository @Inject constructor(
    private val apiService: BitrixApiService
) {
    suspend fun getOrderDetails(orderId: String): BitrixOrderDetail {
        val response = apiService.getOrderDetails(
            webhookId = "1",
            webhookKey = "90fr03z5z99ecggz",
            orderId = orderId
        )
        return if (response.isSuccessful) {
            response.body()?.order ?: throw Exception("Order not found")
        } else {
            throw Exception("Failed to fetch order details")
        }
    }
    suspend fun getOrders(): List<BitrixOrder> {
        val response = apiService.getOrders(
            webhookId = "1",
            webhookKey = "90fr03z5z99ecggz",
            filter = mapOf(">=DATE_INSERT" to "2024-01-01")
        )
        return if (response.isSuccessful) {
            response.body()?.orders?.map { it.toDomain() } ?: emptyList()
        } else {
            emptyList()
        }
    }
}