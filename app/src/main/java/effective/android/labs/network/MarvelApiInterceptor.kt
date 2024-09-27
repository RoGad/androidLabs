package effective.android.labs.network

import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest

class MarvelApiInterceptor(
    private val publicKey: String,
    private val privateKey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val timestamp = System.currentTimeMillis().toString()
        val hash = generateHash(timestamp, privateKey, publicKey)

        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("ts", timestamp)
            .addQueryParameter("hash", hash)
            .build()

        val request = original.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(request)
    }

    private fun generateHash(timestamp: String, privateKey: String, publicKey: String): String {
        val input = "$timestamp$privateKey$publicKey"
        return input.md5()
    }
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}