// data/OrderRepository.kt
package com.bitrix.orders.data

import com.bitrix.orders.model.BitrixOrder
import com.bitrix.orders.model.BitrixOrderDetail
import com.bitrix.orders.model.BitrixOrderDetailResponse
//import com.bitrix.orders.model.BitrixOrderResponse
// import com.bitrix.orders.model.Order
// import com.bitrix.orders.network.BitrixApiService
import retrofit2.Response
import javax.inject.Inject
import com.bitrix.orders.network.BitrixApiService

class OrderRepository @Inject constructor(
    private val apiService: BitrixApiService
) {
    suspend fun getOrders(): List<BitrixOrder> {
        val response = apiService.getOrders()
        return if (response.isSuccessful) {
            response.body()?.orders?.map { it.toDomain() } ?: emptyList()
        } else {
            emptyList()
        }
    }

    suspend fun getOrderDetails(orderId: String): BitrixOrder {
        val response = apiService.getOrderDetails(orderId)
        return if (response.isSuccessful) {
            response.body()?.order?.toDomain() ?: throw Exception("Order not found")
        } else {
            throw Exception("Failed to fetch order details")
        }
    }
}