// network/BitrixApiService.kt
package com.bitrix.orders.network


import com.bitrix.orders.model.BitrixOrder
import com.bitrix.orders.model.BitrixOrderDetailResponse

import com.google.gson.annotations.SerializedName
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface BitrixApiService {
    @GET("rest/{webhook_id}/{webhook_key}/sale.order.list")
    suspend fun getOrders(
        @Path("webhook_id") webhookId: String,
        @Path("webhook_key") webhookKey: String,
        @Query("filter") filter: Map<String, String> = emptyMap() // Опциональные фильтры
    ): Response<BitrixOrderResponse>
    @GET("rest/{webhook_id}/{webhook_key}/sale.order.get")
    suspend fun getOrderDetails(
        @Path("webhook_id") webhookId: String,
        @Path("webhook_key") webhookKey: String,
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

