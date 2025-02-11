// com/bitrix/orders/work/NotificationWorker.kt:
package com.bitrix.orders.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

class NotificationWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        // Проверка новых заказов и отправка уведомлений
        return try {
            // Реализуйте проверку новых заказов
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}

// Запуск в Application классе:
val workRequest = PeriodicWorkRequestBuilder<NotificationWorker>(
    15, TimeUnit.MINUTES
).build()
//WorkManager.getInstance(context).enqueue(workRequest)