// com/bitrix/orders/screens/OrderDetailScreen.kt:
package com.bitrix.orders.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.bitrix.orders.viewmodels.OrderDetailViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface


@Composable
fun OrderDetailScreen(orderId: String) {
    val viewModel: OrderDetailViewModel = hiltViewModel()
    val state = viewModel.orderState.collectAsState().value

    LaunchedEffect(orderId) {
        viewModel.loadOrderDetails(orderId)
    }

    Surface {
        when {
            state == null -> Text("Loading...")
            else -> {
                Column {
                    Text("Order ID: ${state.id}")
                    Text("Date: ${state.dateCreated}")
                    Text("Total: ${state.totalPrice} ${state.currency}")
                    Text("Status: ${state.statusCode}")
                }
            }
        }
    }
}