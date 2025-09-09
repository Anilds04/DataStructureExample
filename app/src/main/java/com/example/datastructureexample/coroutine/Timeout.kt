package com.example.datastructureexample.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.Result

fun main() {

    runBlocking {
        val result = fetchWithTimeout()

        println(result)
    }
}


suspend fun fetchWithTimeout(): String {

    return withTimeoutOrNull(1000) {
        getData()
    } ?: "TimeOut"
}


suspend fun getData(): String {
    delay(1900)
    return "Success"
}


class SecureStorage {
    fun getAccessToken(): String? = null
    fun getExpireToken(): Long? = null

    fun isExpired(): Boolean {
        return true
    }
}

suspend fun getToken(secureStorage: SecureStorage?): Response {

    val token = secureStorage?.getAccessToken()

    token?.let {
        if(secureStorage.isExpired()){


            //getRefreshToken()
        }
        else{
            return Response.Success(token)
        }
    }

    return Response.Failure(exception = IllegalStateException())

}


sealed class Response(val token: String? = null, val exception: Exception? = null) {
    class Success(token: String) : Response(token = token)
    class Failure(exception: Exception) : Response(exception = exception)
}


