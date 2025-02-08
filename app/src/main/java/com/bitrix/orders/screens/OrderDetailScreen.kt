package com.bitrix.orders.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bitrix.orders.viewmodels.OrderDetailViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface


@Composable
fun OrderDetailScreen(
    orderId: String,
    modifier: Modifier = Modifier
) {
    val viewModel: OrderDetailViewModel = hiltViewModel()
    val state = viewModel.orderState.collectAsState().value

    LaunchedEffect(orderId) {
        viewModel.loadOrderDetails(orderId)
    }

    Surface(modifier = modifier) { // Добавлен контейнер
        when {
            state == null -> Text("Loading...")
            else -> {
                Column {
                    Text("Order ID: ${state.id}")
                    Text("Total: ${state.totalPrice}")
                }
            }
        }
    }
}