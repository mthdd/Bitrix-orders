// network/BitrixApiService.kt
package com.bitrix.orders.network

import com.bitrix.orders.model.BitrixOrderDetail
import com.bitrix.orders.model.BitrixOrderDetailResponse

import com.bitrix.orders.model.Order
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BitrixApiService {
    @GET("sale.order.list")
    suspend fun getOrders(): Response<BitrixOrderResponse>

    @GET("sale.order.get")
    suspend fun getOrderDetails(
        @Query("id") orderId: String
    ): Response<BitrixOrderDetailResponse>
}

data class BitrixOrderDetailResponse(
    @SerializedName("ID") val id: String,
    @SerializedName("DATE_INSERT") val date: String,
    @SerializedName("PRICE") val totalPrice: Double,
    @SerializedName("result") val orders: List<BitrixOrder>,
    @SerializedName("total") val total: Int = 0)

data class BitrixOrderResponse(
    @SerializedName("result") val orders: List<BitrixOrder>,
    @SerializedName("total") val total: Int
)

data class BitrixOrder(
    @SerializedName("ID") val id: String,
    @SerializedName("DATE_INSERT") val date: String,
    @SerializedName("PRICE") val totalPrice: Double,
    @SerializedName("STATUS_ID") val status: String
)

