package com.bitrix.orders.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bitrix.orders.screens.OrderDetailScreen
import com.bitrix.orders.screens.OrderListScreen

object NavRoutes {
    const val ORDER_LIST = "order_list"
    const val ORDER_DETAIL = "order_detail"
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.ORDER_LIST
    ) {
        composable(NavRoutes.ORDER_LIST) {
            OrderListScreen(navController)
        }
        composable("${NavRoutes.ORDER_DETAIL}/{orderId}") {
            OrderDetailScreen(orderId = it.arguments?.getString("orderId") ?: "")
        }
    }
}