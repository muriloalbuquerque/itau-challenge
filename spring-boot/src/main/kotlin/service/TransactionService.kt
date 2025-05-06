package service

import dto.StatisticsResponse
import model.Transaction
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue

@Service
class TransactionService {

    private val transactions: Queue<Transaction> = ConcurrentLinkedQueue()

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun getAllTransactions(): List<Transaction> {
        return transactions.toList()
    }

    fun clearTransactions() {
        transactions.clear()
    }

    fun getStatistics(): StatisticsResponse {
        val now = OffsetDateTime.now()
        val oneMinuteAgo = now.minusSeconds(60)

        val valoresRecentes = transactions
            .filter { it.dataHora.isAfter(oneMinuteAgo) }
            .map { it.valor.toDouble() }

        val count = valoresRecentes.size.toLong()
        val sum = valoresRecentes.sum()
        val avg = if (valoresRecentes.isNotEmpty()) valoresRecentes.average() else 0.0
        val min = valoresRecentes.minOrNull() ?: 0.0
        val max = valoresRecentes.maxOrNull() ?: 0.0

        return StatisticsResponse(
            count = count,
            sum = sum,
            avg = avg,
            min = min,
            max = max
        )
    }
}
