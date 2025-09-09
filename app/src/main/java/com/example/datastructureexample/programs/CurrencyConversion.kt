package com.example.datastructureexample.programs

import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.serialization.*
import kotlinx.serialization.json.*



fun main() {
    val service = ExchangeRateService()
    val euroAmount = 100.0
    val gbpAmount = service.convertEuroToGbp(euroAmount)
    println("€$euroAmount = £$gbpAmount")
}


@Serializable
data class ConvertResponse(
    val success: Boolean,
    val query: Query,
    val info: Info,
    val result: Double
)

@Serializable
data class Query(val from: String, val to: String, val amount: Double)

@Serializable
data class Info(val rate: Double)

class ExchangeRateService {

    private var cachedRate: ExchangeRate? = null
    private val apiUrl = "  "

    fun convertEuroToGbp(amount: Double): Double {
        val rate = getRate()
        return rate

    }

    private fun getRate(): Double {
        // Return cached rate if less than 1 hour old
        val now = System.currentTimeMillis()
        cachedRate?.let {
            if (now - it.timestamp < 3600_000) {
                return it.rate
            }
        }

        val newRate = fetchRateFromApi()
        cachedRate = ExchangeRate("EUR", "GBP", newRate)
        return newRate
    }

    private fun fetchRateFromApi(): Double {
        try {
            val connection = URL(apiUrl).openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            if (connection.responseCode == 200) {
                val json = connection.inputStream.bufferedReader().readText()

                val gson = Gson()
                val response = gson.fromJson(json, ConvertResponse::class.java)

                // Try "result" (if using /convert), else fallback to GBP in rates
                return response.result

            } else {
                throw RuntimeException("API request failed with code ${connection.responseCode}")
            }
        } catch (ex: Exception) {
            println("⚠️ Failed to fetch rate: ${ex.message}")
            return cachedRate?.rate ?: 0.0
        }
    }
}


data class ExchangeRate(
    val fromCurrency: String,
    val toCurrency: String,
    val rate: Double,
    val timestamp: Long = System.currentTimeMillis()  // default to current time
)