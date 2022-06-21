package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.domain.CardsDomain
import ru.lemaitre.bankcomposesample.common.main.domain.model.Screens
import ru.lemaitre.bankcomposesample.common.ui.component.CardItem
import ru.lemaitre.bankcomposesample.common.ui.theme.GrayAlpha54
import ru.lemaitre.bankcomposesample.common.ui.theme.blueA400
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.mappers.toUi
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.CardUi
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.CardsUi

@Composable
fun CardsComponent(
    rotateCallback: (Boolean) -> Unit,
    startShow: Boolean,
    cardsUi: List<CardsUi>,
    name: String = "Карты",
    navController: NavController,
    idNavigate: String = "card",
    selected: (String) -> Unit
) {
    var rotate by rememberSaveable { mutableStateOf(startShow) }
    val rotateExtra by animateFloatAsState(
        if (rotate) 90F else 0F
    )
    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        rotate = !rotate
                        rotateCallback(rotate)
                    }) {
                    Text(
                        text = name
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = stringResource(id = R.string.main_screen_show_cards),
                        modifier = Modifier.rotate(rotateExtra)
                    )
                }
            }
            Column(modifier = Modifier
                .padding(8.dp)
                .clickable {
                    navController.navigate(Screens.NewProduct.name + "/${idNavigate}")
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription = stringResource(id = R.string.main_screen_add_card)
                )
            }
        }
    }

    cardsUi.forEach { uiModel ->
        if (rotate) {
            if (uiModel is CardUi) {
                CardItem(uiModel = uiModel, selected = selected)
            }
            //todo if(error,empty)
        }
    }
}