package ru.lemaitre.bankcomposesample.common.data

data class ResultDTO(
    val status: Status
)

enum class Status{
    SUCCESS, ERROR
}
