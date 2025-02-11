// com/bitrix/orders/screens/OrderListScreen.kt:
package com.bitrix.orders.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bitrix.orders.components.OrderListItem
import com.bitrix.orders.viewmodels.OrderViewModel
import com.bitrix.orders.model.Order

@Composable
fun OrderListScreen(navController: NavController) {
    val viewModel: OrderViewModel = hiltViewModel()
    val state = viewModel.ordersState.collectAsState().value

    // Загрузка данных при первом открытии экрана
    LaunchedEffect(Unit) {
        viewModel.loadOrders()
    }

    // Отображение состояния
    when {
        state.isLoading -> CircularProgressIndicator() // Индикатор загрузки
        state.error != null -> Text(text = "Error: ${state.error}") // Ошибка
        else -> {
            // Список заказов
            LazyColumn {
                items(
                    items = state.orders,
                    key = { order -> order.id } // Уникальный ключ для каждого элемента
                ) { order ->
                    OrderListItem(
                        order = order,
                        onItemClick = { orderId ->
                            println("Navigating to order detail with ID: $orderId") // Лог для отладки
                            navController.navigate("order_detail/$orderId")
                        }
                    )
                }
            }
        }
    }
}