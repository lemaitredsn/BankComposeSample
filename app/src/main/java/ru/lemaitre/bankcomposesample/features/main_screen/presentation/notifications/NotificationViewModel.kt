package ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.lemaitre.bankcomposesample.features.notification_screen.domain.NotificationUseCase
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NotificationModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val notificationsUseCase: NotificationUseCase
): ViewModel() {

    private val _notifications = mutableStateOf(emptyList<NotificationModel>())
    var notifications: State<List<NotificationModel>> = _notifications
    //todo add state
    init {
        getNotifications()
    }

    private fun getNotifications() {
        _notifications.value = notificationsUseCase()
    }

}