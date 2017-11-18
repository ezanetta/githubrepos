package com.androiddevsbsas.githubrepos.networking

import com.androiddevsbsas.githubrepos.model.GitHubRepo
import retrofit2.Call
import retrofit2.http.GET

interface GitHubApi {

    @GET("repositories")
    fun getPublicRepositories(): Call<List<GitHubRepo>>
}