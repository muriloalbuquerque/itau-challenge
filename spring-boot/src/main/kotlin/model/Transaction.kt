package model

import java.time.OffsetDateTime
import java.math.BigDecimal

class Transaction(
    val valor: BigDecimal,
    val dataHora: OffsetDateTime
)
