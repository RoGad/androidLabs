package effective.android.labs.network

import java.math.BigInteger

class MarvelRepository {
    private val apiService = RetrofitClient.apiService
    private val publicKey = "297a6f506c83c6ceb5152f7aeea7e858"
    private val privateKey = "fb2cd4a62122921fb0e8d8021c4499604fdf43bc"

    suspend fun getCharacters(): List<MarvelCharacter> {
        val timestamp = System.currentTimeMillis().toString()
        val hash = generateHash(timestamp, privateKey, publicKey)
        return apiService.getCharacters(publicKey, timestamp, hash).data.results
    }

    suspend fun getCharacter(characterId: Int): MarvelCharacter {
        val timestamp = System.currentTimeMillis().toString()
        val hash = generateHash(timestamp, privateKey, publicKey)
        return apiService.getCharacter(characterId, publicKey, timestamp, hash).data.results.first()
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