package controller

import dto.StatisticsResponse
import dto.TransactionRequest
import model.Transaction
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import service.TransactionService
import java.math.BigDecimal
import java.time.OffsetDateTime

@RestController
@RequestMapping("/transacao")
class TransactionController(
    private val transactionService: TransactionService
) {

    @PostMapping
    fun addTransaction(@RequestBody transactionRequest: TransactionRequest): ResponseEntity<Unit> {
        val transaction = Transaction(
            valor = transactionRequest.valor,
            dataHora = transactionRequest.dataHora
        )

        if (transaction.dataHora.isAfter(OffsetDateTime.now())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build()
        }

        if (transaction.valor < BigDecimal.ZERO) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build()
        }

        transactionService.addTransaction(transaction)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping
    fun getAllTransactions(): List<Transaction> {
        return transactionService.getAllTransactions()
    }

    @DeleteMapping
    fun clearTransactions() {
        transactionService.clearTransactions()
    }

    @GetMapping("/estatisticas")
    fun getStatistics(): StatisticsResponse {
        return transactionService.getStatistics()
    }
}
