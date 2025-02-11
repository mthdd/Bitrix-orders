// com/bitrix/orders/components/OrderListItem.kt:
package com.bitrix.orders.components

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bitrix.orders.model.Order

@Composable
fun OrderListItem(
    order: Order,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        onClick = { onItemClick(order.id) }
    ) {
        Text(text = "Заказ #${order.id}")
        Text(text = "Сумма: ${order.totalPrice}")
        Text(text = "Статус: ${order.status}")
    }
}