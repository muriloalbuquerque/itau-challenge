package dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.OffsetDateTime

data class TransactionRequest(
    @field:NotNull(message = "O valor não pode ser nulo")
    @field:Min(value = 0, message = "O valor deve ser ≥ 0")
    val valor: BigDecimal,

    @field:NotNull(message= "A data e a hora nao podem ser nulas")

    val dataHora: OffsetDateTime
)
