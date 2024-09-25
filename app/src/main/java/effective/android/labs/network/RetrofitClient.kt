package effective.android.labs.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import effective.android.labs.constants.SecretData.PRIVATE_KEY
import effective.android.labs.constants.SecretData.PUBLIC_KEY
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://gateway.marvel.com/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val marvelInterceptor = MarvelApiInterceptor(PUBLIC_KEY, PRIVATE_KEY)

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor(marvelInterceptor)
        .build()

    val apiService: MarvelApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MarvelApiService::class.java)
    }
}