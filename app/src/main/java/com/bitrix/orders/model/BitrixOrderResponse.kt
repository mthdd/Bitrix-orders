// com/bitrix/orders/model/BitrixOrderResponse.kt
package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName


data class BitrixOrderResult(
    @SerializedName("orders") val orders: List<BitrixOrder>
)