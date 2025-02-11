// com/bitrix/orders/model/BitrixOrderDetailResponse.kt:
package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName

data class BitrixOrderDetailResponse(
    @SerializedName("result") val result: BitrixOrderDetailResult
)

data class BitrixOrderDetailResult(
    @SerializedName("order") val order: BitrixOrderDetail
)