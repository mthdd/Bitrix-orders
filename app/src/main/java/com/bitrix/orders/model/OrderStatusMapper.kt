// com/bitrix/orders/model/OrderStatusMapper.kt
package com.bitrix.orders.model

import androidx.compose.ui.graphics.Color


object OrderStatusMapper {
    private val statusMap = mapOf(
        "bx_28497a42df1316f55e108f76cff8b50e" to "Новый",
        "bx_7e16636afb5ade5bdb115421ac20fac9" to "Готовится",
        "bx_62829e4b6c6d0" to "Готов",
        "bx_dfbe77d2d90fe26b23d7f15307ad2c55" to "Выполнен"
    )

    // Получение текстового статуса по коду
    fun getStatusText(statusCode: String): String {
        return statusMap[statusCode] ?: "Неизвестный статус"
    }

    // Получение цвета фона по статусу
    fun getStatusColor(statusText: String, isBackground: Boolean = true): Color {
        return when (statusText) {
            "Новый" -> if (isBackground) Color(0xFFFFCDD2) else Color(0xFFD32F2F) // Красный
            "Готовится" -> if (isBackground) Color(0xFFC8E6C9) else Color(0xFF388E3C) // Зеленый
            "Готов" -> if (isBackground) Color(0xFFFFE0B2) else Color(0xFFF57C00) // Оранжевый
            "Выполнен" -> if (isBackground) Color(0xFFF5F5F5) else Color(0xFF9E9E9E) // Серый
            else -> if (isBackground) Color(0xFFEEEEEE) else Color(0xFF000000) // По умолчанию
        }
    }
}