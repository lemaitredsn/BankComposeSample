package ru.lemaitre.bankcomposesample.features.notification_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NotificationsScreen(/*поидее сюда нужно добавлять список*/) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val mock = listOf(
            NotificationModel("Сообщение от банка", 3221),
            NotificationModel("Выполнена транзакция", 3321),
            NotificationModel("Пополнение", 3424),
        )
        mock.forEach {
            NotificationItem(it)
        }
    }
}


data class NotificationModel(val title: String, val id: Int)

@Composable
@Preview
fun NotificationItem(notification: NotificationModel = NotificationModel(
    "hello world", 2
)) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Filled.Notifications,
            modifier = Modifier
                .padding(16.dp)
                .width(24.dp)
                .height(24.dp),
            contentDescription = notification.title
        )
        Text(text = notification.title)
    }
}