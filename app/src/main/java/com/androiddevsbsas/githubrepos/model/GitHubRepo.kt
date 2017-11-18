package com.androiddevsbsas.githubrepos.model

import com.google.gson.annotations.SerializedName

data class GitHubRepo(@SerializedName("name") val name: String,
                      @SerializedName("html_url") val htmlUrl: String,
                      @SerializedName("description") val description: String,
                      @SerializedName("owner") val owner: Owner)