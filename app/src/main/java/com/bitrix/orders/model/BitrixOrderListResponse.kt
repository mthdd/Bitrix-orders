// com/bitrix/orders/model/BitrixOrderListResponse.kt
package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName

data class BitrixOrderListResponse(
    @SerializedName("result") val result: BitrixOrderListResult
)

data class BitrixOrderListResult(
    @SerializedName("orders") val orders: List<BitrixOrder>,
    @SerializedName("total") val total: Int
)