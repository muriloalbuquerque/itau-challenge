package dto

import java.util.DoubleSummaryStatistics

data class StatisticsResponse(
    val count: Long,
    val sum: Double,
    val avg: Double,
    val min: Double,
    val max: Double
) {
    companion object {
        fun from(stats: DoubleSummaryStatistics): StatisticsResponse {
            return StatisticsResponse(
                count = stats.count,
                sum = stats.sum,
                avg = stats.average,
                min = stats.min,
                max = stats.max
            )
        }
    }
}
