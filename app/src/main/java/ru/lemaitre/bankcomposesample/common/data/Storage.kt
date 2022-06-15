package ru.lemaitre.bankcomposesample.common.data

import android.util.Log
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.data.models.AutoTransferDTO
import ru.lemaitre.bankcomposesample.common.domain.*
import ru.lemaitre.bankcomposesample.common.ui.theme.Purple700
import ru.lemaitre.bankcomposesample.common.ui.theme.orange400
import ru.lemaitre.bankcomposesample.common.ui.theme.redA400
import ru.lemaitre.bankcomposesample.common.ui.theme.yellow400
import ru.lemaitre.bankcomposesample.features.main_screen.data.models.NewProductsDTO
import ru.lemaitre.bankcomposesample.features.main_screen.data.models.NotificationDTO
import ru.lemaitre.bankcomposesample.features.main_screen.data.models.ProfileDTO
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.DetailModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.HistoryItem
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.OffersModel
import javax.inject.Inject
import kotlin.random.Random

//Пока тут будет храниться все модели сервера

class Storage @Inject constructor() {

    fun getCardProduct(): List<CardProductModel> {
        return /*emptyList<CardProductModel>()*/ listOf( //FIXME this is UI model
            CardProductModel(
                number = "1321 3213 3213 0001",
                typeCard = TypeCard.CREDIT,
                paySystem = PaySystem.UNION_PAY,
                amount = "999 999,91"
            ),
            CardProductModel(
                number = "1321 3213 3213 0002",
                typeCard = TypeCard.DEBIT,
                paySystem = PaySystem.MIR,
                amount = "275 443,21"
            ),
            CardProductModel(
                number = "1321 3213 3213 0003",
                typeCard = TypeCard.SALARY,
                paySystem = PaySystem.MASTER_CARD,
                amount = "54 443,23"
            ),
            CardProductModel(
                number = "1321 3213 3213 0004",
                typeCard = TypeCard.SALARY,
                paySystem = PaySystem.VISA,
                currency = Currency.DOLLAR,
                amount = "1643,43"
            ),
            CardProductModel(
                number = "1321 3213 3213 0005",
                typeCard = TypeCard.DEBIT,
                paySystem = PaySystem.MASTER_CARD,
                currency = Currency.EURO,
                amount = "88,76"
            ),
            CardProductModel(
                number = "1321 3213 3213 0006",
                typeCard = TypeCard.SALARY,
                paySystem = PaySystem.VISA,
                currency = Currency.DOLLAR,
                amount = "1643,43"
            ),
            CardProductModel(
                number = "1321 3213 3213 0007",
                typeCard = TypeCard.DEBIT,
                paySystem = PaySystem.MASTER_CARD,
                currency = Currency.EURO,
                amount = "88,76"
            ),
        )
    }

    suspend fun getOffers(): List<OffersModel> { //FIXME UI MOdel
        return listOf(
            OffersModel(
                id = 1,
                title = "Кредит 15%",
                description = "Акция действует до 14 мая",
                backgroundColor = Purple700
            ),
            OffersModel(
                id = 2,
                title = "Депозит 23%",
                description = "Акция до 25 июня",
                backgroundColor = redA400
            ),
            OffersModel(
                id = 3,
                title = "Рассрочка 10",
                description = "Рассрочка 10 месяцев",
                backgroundColor = yellow400
            ),
            OffersModel(
                id = 4,
                title = "Карта МИР",
                description = "Получи карту мир прямо в приложении",
                backgroundColor = orange400
            ),
        )
    }

    fun getAccountProducts(): List<AccountProductModel> {
        return listOf(
            AccountProductModel( //FIXME UI model
                typeAccount = TypeAccount.CURRENT,
                userNameAccount = "Текущий",
                number = "4258 1223 1365 1236 0001",
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
                number = "4258 1223 1365 1236 0002",
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
                number = "4258 1223 1365 1236 0003",
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
                number = "4258 1223 1365 1236 0004",
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

    fun getProducts(): List<Products> {
        return getAccountProducts()
            .plus(getCardProduct())
    }

    fun findCardHistory(number: String): List<HistoryItem> {
        return when {
            number == "1321 3213 3213 0001" -> listOf(
                HistoryItem(123.0, true, "Тест")
            )
            number == "1321 3213 3213 0002" -> listOf(
                HistoryItem(321.0, true, "Тестовые")
            )
            number == "1321 3213 3213 0003" -> listOf(
                HistoryItem(321.0, true, "Тестовые")
            )
            number == "1321 3213 3213 0004" -> listOf(
                HistoryItem(321.0, true, "Тестовые")
            )
            number == "1321 3213 3213 0005" -> listOf(
                HistoryItem(321.0, true, "Тестовые")
            )
            number == "1321 3213 3213 0006" -> listOf(
                HistoryItem(321.0, true, "Тестовые")
            )
            number == "1321 3213 3213 0007" -> listOf(
                HistoryItem(321.0, true, "Тестовые")
            )
            else -> emptyList()
        }

    }

    fun findAccountHistory(number: String): List<HistoryItem> {
        return when {
            number == "4258 1223 1365 1236 0001" -> listOf(
                HistoryItem(12423.0, true, "Тест")
            )
            number == "4258 1223 1365 1236 0002" -> listOf(
                HistoryItem(343121.0, true, "Тестовые")
            )
            number == "4258 1223 1365 1236 0003" -> listOf(
                HistoryItem(352321.0, true, "Тестовые")
            )
            number == "4258 1223 1365 1236 0004" -> listOf(
                HistoryItem(754321.0, true, "Тестовые")
            )
            else -> emptyList()
        }
    }

    fun getHistory(productNumber: String): DetailModel {
        Log.e("TAG", "getHistory $productNumber")
        val card = getCardProduct().firstOrNull() { it.number == productNumber }
        val account = getAccountProducts().firstOrNull() { it.number == productNumber }
        val s = when {
            card != null -> {
                DetailModel(
                    sum = card.amount,
                    number = card.number,
                    icon = card.paySystem.icon,
                    findCardHistory(productNumber)
                )
            }
            account != null -> {
                DetailModel(
                    sum = account.amount,
                    number = account.number,
                    icon = R.drawable.ic_card,
                    findAccountHistory(productNumber)
                )
            }
            else -> {
                throw IllegalArgumentException("Продукта по номеру ненйдено")
            }
        }
        Log.e("TAG", "$s")
        return s

    }

    fun getProfile() =
        ProfileDTO(
            name = "Вячеслав",
            surname = "Иванов",
            R.drawable.ic_profile_circle,
            phone = "89143335566"
        )

    fun getNotifications(): List<NotificationDTO> {
        return listOf(
            NotificationDTO(
                1,
                "Сообщение от банка",
                "Уважаемый клиент сообщаем Вам, что у нас появился новый продукт...",
                "31-01-2022"
            ),
            NotificationDTO(
                2,
                "Выполнена транзакция",
                "Поступление по карте 1321 3213 3213 0001 + 321р",
                "25-08-2021"
            ),

            NotificationDTO(
                3,
                "Выполнена транзакция",
                "Поступление по карте 1321 3213 3213 0001 + 321р",
                "12-12-2021"
            )
        )
    }

    fun sendOffer(idOffer: String): ResultDTO {
        return getRandomResultDTO()
    }

    fun getNewProducts(productName: String): List<NewProductsDTO> {
        return when (productName) {
            "card" ->
                listOf(
                    NewProductsDTO(
                        "Стандарт", "Стандартная карта",
                        "Рубли", "4 года", "Стандартные условия"
                    ),
                    NewProductsDTO(
                        "Доллар", "Если нужны доллары",
                        "доллар", "евро", "4 года"
                    ),
                    NewProductsDTO(
                        "Евро", "Евро для поездок в Европу",
                        "евро", "4 года", "Лучшие"
                    )
                )
            "account" -> listOf(
                NewProductsDTO(
                    "Транспорт стандарт",
                    "Транспорт стандарт - стандартный счет для отправки денежных средств",
                    "Рубли",
                    "Бессрочный",
                    "0 рублей - за открытие, 0 - обслуживание"
                ),
                NewProductsDTO(
                    "Транспорт валюта", "Транспорт валютный",
                    "Евро, доллар, юань", "бессроочный", "0.01% - за перевод"
                ),
                NewProductsDTO(
                    "Кэшбек",
                    "Счет для получении максимальной выгоды",
                    "Рубли",
                    "4 года",
                    "Делайте 10 покупок на сумму более 10 000р. для получения 10% кэшбека"
                ),
                NewProductsDTO(
                    "Пятерка", "Супер счет пятерка",
                    "Рубли", "Бессрочный", "Кэшбек на остаток 5%, кэшбек на покупку - 5%"
                )
            )
            else -> error("unknown product name")
        }
    }

    private fun getRandomResultDTO(
        success: String = "Заявка отправлена",
        error: String = "При отправке произошла ошибка"
    ): ResultDTO {
        var status = ""
        var message = ""
        if (Random.nextBoolean()) {
            status = "Успех"
            message = "Заявка отправлена"
        } else {
            status = "Ошибка"
            message = "При отправке произошла ошибка"
        }
        return ResultDTO(
            status = status,
            message = message
        )
    }

    fun sendOrderedProduct(name: String): ResultDTO {
        return getRandomResultDTO()
    }

    fun getAutoTransfers(): List<AutoTransferDTO> {
        return listOf(
            AutoTransferDTO(
                "Оплатить по QR",
                1
            ),
            AutoTransferDTO(
                "Капремонт",
                2
            ),
            AutoTransferDTO(
                "Оплата телефона",
                3
            ),
            AutoTransferDTO(
                "Газ",
                4
            ),
            AutoTransferDTO(
                "Оплата воды",
                5
            )
        )
    }

}