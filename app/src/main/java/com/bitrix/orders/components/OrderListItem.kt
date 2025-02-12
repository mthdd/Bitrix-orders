// com/bitrix/orders/components/OrderListItem.kt:
package com.bitrix.orders.components

import android.icu.text.NumberFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bitrix.orders.model.Order
import com.bitrix.orders.model.OrderStatusMapper
import java.util.Locale

@Composable
fun OrderListItem(
    order: Order,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = OrderStatusMapper.getStatusColor(order.statusText, isBackground = true)
    val textColor = OrderStatusMapper.getStatusColor(order.statusText, isBackground = false)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        onClick = { onItemClick(order.id) },
        colors = CardDefaults.cardColors(containerColor = backgroundColor) // Цвет фона
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Блок 1 - Номер заказа
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Заказ",
                    style = MaterialTheme.typography.labelMedium,
                    color = textColor
                )
                Text(
                    text = "#${order.id}",
                    style = MaterialTheme.typography.titleMedium,
                    color = textColor
                )
            }

            // Блок 2 - Сумма
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Сумма",
                    style = MaterialTheme.typography.labelMedium,
                    color = textColor
                )
                Text(
                    text = "${order.totalPrice} ${order.currency}",
                    style = MaterialTheme.typography.titleMedium,
                    color = textColor
                )
            }

            // Блок 3 - Статус
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "Статус",
                    style = MaterialTheme.typography.labelMedium,
                    color = textColor
                )
                Text(
                    text = order.statusText,
                    style = MaterialTheme.typography.titleMedium,
                    color = textColor
                )
            }
        }
    }
}
fun formatPrice(price: Double, currency: String): String {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return "${formatter.format(price)} $currency"
}