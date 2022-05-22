package ru.lemaitre.bankcomposesample.features.main_screen.data

import kotlinx.coroutines.delay
import ru.lemaitre.bankcomposesample.common.domain.*
import ru.lemaitre.bankcomposesample.features.main_screen.domain.MainScreenRepository
import ru.lemaitre.bankcomposesample.features.main_screen.domain.OffersModel
import ru.lemaitre.bankcomposesample.ui.theme.Purple700
import ru.lemaitre.bankcomposesample.ui.theme.orange400
import ru.lemaitre.bankcomposesample.ui.theme.redA400
import ru.lemaitre.bankcomposesample.ui.theme.yellow400
import javax.inject.Inject
import kotlin.random.Random

class MainScreenRepositoryImpl @Inject constructor() : MainScreenRepository {
    override suspend fun getUserName(): String {
        return "Вячеслав ${Random.nextInt(100)}"
    }

    override suspend fun getCardProduct(): List<CardProductModel> {
        return /*emptyList<CardProductModel>()*/ listOf(
            CardProductModel(
                typeCard = TypeCard.CREDIT,
                paySystem = PaySystem.UNION_PAY,
                amount = "999 999,91"
            ),
            CardProductModel(
                typeCard = TypeCard.DEBIT,
                paySystem = PaySystem.MIR,
                amount = "275 443,21"
            ),
            CardProductModel(
                typeCard = TypeCard.SALARY,
                paySystem = PaySystem.MASTER_CARD,
                amount = "54 443,23"
            ),
            CardProductModel(
                typeCard = TypeCard.SALARY,
                paySystem = PaySystem.VISA,
                currency = Currency.DOLLAR,
                amount = "1643,43"
            ),
            CardProductModel(
                typeCard = TypeCard.DEBIT,
                paySystem = PaySystem.MASTER_CARD,
                currency = Currency.EURO,
                amount = "88,76"
            ),
            CardProductModel(
                typeCard = TypeCard.SALARY,
                paySystem = PaySystem.VISA,
                currency = Currency.DOLLAR,
                amount = "1643,43"
            ),
            CardProductModel(
                typeCard = TypeCard.DEBIT,
                paySystem = PaySystem.MASTER_CARD,
                currency = Currency.EURO,
                amount = "88,76"
            ),
        )

    }

    override suspend fun getOffers(): List<OffersModel> {
        return listOf(
            OffersModel(
                title = "Кредит 15%",
                description = "Акция действует до 14 мая",
                backgroundColor = Purple700
            ),
            OffersModel(
                title = "Депозит 23%",
                description = "Акция до 25 июня",
                backgroundColor = redA400
            ),
            OffersModel(
                title = "Рассрочка 10",
                description = "Рассрочка 10 месяцев",
                backgroundColor = yellow400
            ),
            OffersModel(
                title = "Карта МИР",
                description = "Получи карту мир прямо в приложении",
                backgroundColor = orange400
            ),
        )
    }

    override suspend fun getAccountProducts(): List<AccountProductModel> {
        return listOf(
            AccountProductModel(
                typeAccount = TypeAccount.CURRENT,
                userNameAccount = "Текущий",
                number = "4258 1223 1365 1236 2322",
                amount = "4231",
                currency = Currency.RUBLE,
                status = "ок",
                listOf(
                    CardProductModel(
                        typeCard = TypeCard.CREDIT,
                        paySystem = PaySystem.UNION_PAY,
                        amount = "999 999,91"
                    )
                )
            ),
            AccountProductModel(
                typeAccount = TypeAccount.CURRENT,
                userNameAccount = "Текущий",
                number = "4258 1223 1365 1236 2322",
                amount = "4231",
                currency = Currency.RUBLE,
                status = "ок",
                listOf(
                    CardProductModel(
                        typeCard = TypeCard.CREDIT,
                        paySystem = PaySystem.UNION_PAY,
                        amount = "999 999,91"
                    )
                )
            ),
            AccountProductModel(
                typeAccount = TypeAccount.CURRENT,
                userNameAccount = "Текущий",
                number = "4258 1223 1365 1236 2322",
                amount = "4231",
                currency = Currency.RUBLE,
                status = "ок",
                listOf(
                    CardProductModel(
                        typeCard = TypeCard.CREDIT,
                        paySystem = PaySystem.UNION_PAY,
                        amount = "999 999,91"
                    )
                )
            ),
            AccountProductModel(
                typeAccount = TypeAccount.CURRENT,
                userNameAccount = "Текущий",
                number = "4258 1223 1365 1236 2322",
                amount = "4231",
                currency = Currency.RUBLE,
                status = "ок",
                listOf(
                    CardProductModel(
                        typeCard = TypeCard.CREDIT,
                        paySystem = PaySystem.UNION_PAY,
                        amount = "999 999,91"
                    )
                )
            )
        )
    }

    override suspend fun getProducts(): List<Products> {
        return getAccountProducts()
            .plus(getCardProduct())
    }
}

