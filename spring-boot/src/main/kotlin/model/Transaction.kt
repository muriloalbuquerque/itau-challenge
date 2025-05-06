package model

import java.math.BigDecimal
import java.time.OffsetDateTime

data class Transaction(
    val valor: BigDecimal,
    val dataHora: OffsetDateTime
)
