package ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.lemaitre.bankcomposesample.common.main.domain.model.Screens
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NotificationModel

@Composable
fun NotificationsScreen(navController: NavController, viewModel: NotificationViewModel = hiltViewModel()) {
    //todo добавить открытие экрана для просмотра деталей
    Column(modifier = Modifier.fillMaxWidth()) {
        val notification = viewModel.notifications.value
        notification.forEach { model ->
            NotificationItem(model){
                navController.navigate(Screens.NotificationDetails.name + "/${model.id}")
            }
        }
    }
}


@Composable
fun NotificationItem(notification: NotificationModel, selected:(String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { selected(notification.id.toString()) },
        verticalAlignment = Alignment.CenterVertically,
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