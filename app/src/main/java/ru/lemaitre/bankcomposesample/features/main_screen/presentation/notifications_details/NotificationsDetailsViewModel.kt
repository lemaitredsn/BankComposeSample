package ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications_details

import android.app.Activity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import ru.lemaitre.bankcomposesample.common.main.MainActivity
import ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases.DetailsNotificationUseCase
import ru.lemaitre.bankcomposesample.features.main_screen.mappers.NotificationMapper.toUi
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications.models.NotificationDetailsUI

class NotificationsDetailsViewModel @AssistedInject constructor(
    @Assisted private val notificationId: String,
    private val detailsNotificationUseCase: DetailsNotificationUseCase
) : ViewModel() {

    private val _notification = mutableStateOf(
        NotificationDetailsUI("", "", "", Icons.Filled.Notifications)
    )
    val notification: State<NotificationDetailsUI> = _notification

    init {
        getNotification(notificationId)
    }

    private fun getNotification(notificationId: String) {
        _notification.value = detailsNotificationUseCase(notificationId).toUi()
    }

    @AssistedFactory
    interface Factory {
        fun create(notificationId: String): NotificationsDetailsViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: NotificationsDetailsViewModel.Factory,
            notificationId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(notificationId) as T
            }

        }
    }
}

@Composable
fun provideNotificationsDetailsViewModel(notificationId: String): NotificationsDetailsViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        MainActivity.ViewModelFactoryProvider::class.java
    ).notificationsDetailsViewModelFactory()
    return viewModel(
        factory = NotificationsDetailsViewModel.provideFactory(
            factory,
            notificationId
        )
    )
}