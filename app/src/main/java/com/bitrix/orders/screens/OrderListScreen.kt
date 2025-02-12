// com/bitrix/orders/screens/OrderListScreen.kt:
package com.bitrix.orders.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bitrix.orders.components.OrderListItem
import com.bitrix.orders.viewmodels.OrderViewModel


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
        state.isLoading -> CircularProgressIndicator(
            modifier = Modifier.size(4.dp), // Размер индикатора
            strokeWidth = 4.dp // Толщина линии
        ) // Индикатор загрузки

        state.error != null -> Text(text = "Error: ${state.error}") // Ошибка
        else -> {
            // Список заказов
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(top = 40.dp, bottom = 20.dp) // Отступы сверху и снизу
            ) {
                items(state.orders) { order ->
                    OrderListItem(
                        order = order,
                        onItemClick = { orderId ->
                            navController.navigate("order_detail/$orderId")
                        }
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
                }
            }
        }
    }
}