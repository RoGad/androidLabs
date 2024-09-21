package effective.android.labs.network

import effective.android.labs.constants.SecretData.PRIVATE_KEY
import effective.android.labs.constants.SecretData.PUBLIC_KEY
import effective.android.labs.presentation.model.MarvelCharacter
import java.math.BigInteger

class MarvelRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getCharacters(): List<MarvelCharacter> {
        val timestamp = System.currentTimeMillis().toString()
        val hash = generateHash(timestamp, PRIVATE_KEY, PUBLIC_KEY)
        return apiService.getCharacters(PUBLIC_KEY, timestamp, hash).data.results
    }

    private fun generateHash(timestamp: String, privateKey: String, publicKey: String): String {
        val input = "$timestamp$privateKey$publicKey"
        return input.md5()
    }
}

fun String.md5(): String {
    val md = java.security.MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}