// com/bitrix/orders/viewmodels/OrderViewModel.kt:
package com.bitrix.orders.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

import com.bitrix.orders.data.OrderRepository
import com.bitrix.orders.model.Order

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val repository: OrderRepository
) : ViewModel() {
    private val _ordersState = MutableStateFlow(OrdersState())
    val ordersState: StateFlow<OrdersState> = _ordersState

    fun loadOrders() {
        viewModelScope.launch {
            _ordersState.value = OrdersState(isLoading = true)
            try {
                val orders = repository.getOrders()
                Log.d("OrderViewModel", "Orders loaded: ${orders.size}") // Логирование
                _ordersState.value = OrdersState(orders = orders)
            } catch (e: Exception) {
                Log.e("OrderViewModel", "Error loading orders: ${e.message}", e)
                _ordersState.value = OrdersState(error = e.message)
            }
        }
    }
}

data class OrdersState(
    val orders: List<Order> = emptyList(), // Измените BitrixOrder на Order
    val isLoading: Boolean = false,
    val error: String? = null
)

