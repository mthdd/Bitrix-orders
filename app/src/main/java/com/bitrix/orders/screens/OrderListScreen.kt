package com.bitrix.orders.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bitrix.orders.components.OrderListItem
import com.bitrix.orders.viewmodels.OrderViewModel

@Composable
fun OrderListScreen(navController: NavController) {
    val viewModel: OrderViewModel = hiltViewModel()
    val state = viewModel.ordersState.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.loadOrders()
    }

    when {
        state.isLoading -> CircularProgressIndicator()
        state.error != null -> Text(text = "Error: ${state.error}")
        else -> {
            LazyColumn {
                items(
                    items = state.orders,
                    key = { order -> order.id } // Уникальный ключ для каждого элемента
                ) { order ->
                    OrderListItem(
                        order = order,
                        onItemClick = { orderId: String ->
                            navController.navigate("order_detail/$orderId")
                        }
                    )
                }
            }
        }
    }
}