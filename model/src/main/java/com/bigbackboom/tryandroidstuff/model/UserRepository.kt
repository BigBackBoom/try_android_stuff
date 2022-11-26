package com.bigbackboom.tryandroidstuff.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRepository(
    val id: Int,
    val name: String?,
    @SerialName("html_url")
    val htmlUrl: String,
    val description: String?,
    @SerialName("fork")
    val isFork: Boolean,
    val language: String?,
    @SerialName("stargazers_count")
    val stargazersCount: Int
)
