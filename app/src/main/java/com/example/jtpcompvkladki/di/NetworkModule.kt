package com.example.jtpcompvkladki.di

import com.example.jtpcompvkladki.model.PhotoApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

private const val BASE_URL = "https://picsum.photos/v2/"


val networkModule = module {
    single { headerInterceptor() }
    single { okhttpClient(get()) }
    single { retrofit(get()) }
    single { apiService(get()) }
}

fun apiService(
    retrofit: Retrofit
): PhotoApiService =
    retrofit.create(PhotoApiService::class.java)

fun retrofit(
    okHttpClient: OkHttpClient
): Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

private fun okhttpClient(interceptor: Interceptor): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(interceptor)
    httpClient.addInterceptor(
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    )
    return httpClient.build()
}

class PhotoApiInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        return chain.proceed(chain.request())
    }
}

fun headerInterceptor(): Interceptor =
    Interceptor { chain ->
        val request = chain.request()
        val newUrl = request.url().newBuilder()
//            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()

        val newRequest = request.newBuilder()
            .url(newUrl)
            .build()
        chain.proceed(newRequest)
    }