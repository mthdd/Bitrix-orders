// com/bitrix/orders/network/BitrixApiService.kt
package com.bitrix.orders.network

import com.bitrix.orders.model.BitrixOrderDetailResponse
import com.bitrix.orders.model.BitrixOrderListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BitrixApiService {
    @GET("rest/{webhook_id}/{webhook_key}/sale.order.list")
    suspend fun getOrders(
        @Path("webhook_id") webhookId: String,
        @Path("webhook_key") webhookKey: String
    ): Response<BitrixOrderListResponse>

    @GET("rest/{webhook_id}/{webhook_key}/sale.order.get")
    suspend fun getOrderDetails(
        @Path("webhook_id") webhookId: String,
        @Path("webhook_key") webhookKey: String,
        @Query("id") orderId: String
    ): Response<BitrixOrderDetailResponse>
}