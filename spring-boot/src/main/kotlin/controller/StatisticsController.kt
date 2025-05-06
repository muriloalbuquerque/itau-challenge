package controller

import dto.StatisticsResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import service.TransactionService

@RestController
@RequestMapping("/estatistica")
class StatisticsController(
    private val transactionService: TransactionService
) {

    @GetMapping
    fun getStatistics(): StatisticsResponse {
        return transactionService.getStatistics()
    }
}
