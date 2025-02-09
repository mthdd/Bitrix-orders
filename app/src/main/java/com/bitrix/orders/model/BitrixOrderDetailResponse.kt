package com.bitrix.orders.model

import com.google.gson.annotations.SerializedName
import com.bitrix.orders.model.BitrixOrderDetail

data class BitrixOrderDetailResponse(
    @SerializedName("result") val order: BitrixOrderDetail
)