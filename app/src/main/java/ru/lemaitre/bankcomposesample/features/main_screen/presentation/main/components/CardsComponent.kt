package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import ru.lemaitre.bankcomposesample.common.domain.*
import ru.lemaitre.bankcomposesample.common.main.domain.model.Screens
import ru.lemaitre.bankcomposesample.common.ui.theme.GrayAlpha54
import ru.lemaitre.bankcomposesample.common.ui.theme.blueA400

data class CardsUi(
    val typeCard: TypeCard = TypeCard.SALARY,
    val paySystem: PaySystem = PaySystem.MIR,
    val number: String = "",
    val amount: String = "1523,12",
    val currency: Currency = Currency.RUBLE,
    val status: String? = null,
    @DrawableRes val iconPaySystem: Int,
    @DrawableRes val iconCard: Int = R.drawable.ic_card,
)

fun CardsDomain.toUi() = CardsUi(
    typeCard = this.typeCard,
    paySystem = this.paySystem,
    number = this.number,
    amount = this.amount,
    currency = this.currency,
    status = this.status,
    iconCard = R.drawable.ic_card, //fixme change this test
    iconPaySystem = this.paySystem.getIcon()
)

@Composable
fun CardsComponent(
    rotateCallback: (Boolean) -> Unit,
    startShow: Boolean,
    cardsUi: List<Cards>,
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
                    navController.navigate(Screens.NewProduct.name + "/${idNavigate}") }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription = stringResource(id = R.string.main_screen_add_card)
                )
            }
        }
    }

    cardsUi.forEach {
        if (rotate) {
            if(it is CardsDomain){
                val uiModel = it.toUi()
                Card(
                    modifier = Modifier
                        .padding(4.dp, 2.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .clickable { selected(uiModel.number) },
                    elevation = 8.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.background(blueA400)
                    ) {
                        Image(
                            painter = painterResource(id = uiModel.iconPaySystem),
                            contentDescription = uiModel.paySystem.title,
                            modifier = Modifier
                                .padding(8.dp)
                                .clip(CircleShape)
                                .width(50.dp)
                                .height(50.dp)
                                .background(GrayAlpha54)
                                .padding(8.dp)
                        )
                        Column(modifier = Modifier.weight(1f))
                        {
                            Text(uiModel.typeCard.title)
                            Text(
                                stringResource(
                                    id = R.string.main_screen_card_end,
                                    uiModel.number.takeLast(4)
                                )
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(end = 16.dp)
                        ) {
                            Text(text = "${uiModel.amount} ${uiModel.currency.character}")
                        }
                    }
                }
            }
            //todo if(error,empty)
        }
    }
}