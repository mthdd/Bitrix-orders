package com.bitrix.orders.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bitrix.orders.data.OrderRepository
import com.bitrix.orders.model.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.bitrix.orders.network.BitrixApiService

@HiltViewModel
class OrderDetailViewModel @Inject constructor(
    private val repository: OrderRepository
) : ViewModel() {
    private val _orderState = MutableStateFlow<Order?>(null)
    val orderState: StateFlow<Order?> = _orderState

    fun loadOrderDetails(orderId: String) {
        viewModelScope.launch {
            try {
                val order = repository.getOrderDetails(orderId).toDomain() // Добавьте toDomain()
                _orderState.value = order
            } catch (e: Exception) {
                _orderState.value = null
            }
        }
    }
}