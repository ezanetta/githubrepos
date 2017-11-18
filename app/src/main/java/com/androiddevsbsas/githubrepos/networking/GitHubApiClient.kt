package com.androiddevsbsas.githubrepos.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitHubApiClient {

    val gitHubApi: GitHubApi

    init {
        val httpClient = OkHttpClient.Builder()

        setupLoggingInterceptor(httpClient)

        val client = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()

        gitHubApi = client.create(GitHubApi::class.java)
    }

    private fun setupLoggingInterceptor(httpClient: OkHttpClient.Builder) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)
    }
}