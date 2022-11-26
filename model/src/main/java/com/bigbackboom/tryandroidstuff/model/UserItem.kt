package com.bigbackboom.tryandroidstuff.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserItem(
    val id: Int,
    val login: String,
    @SerialName("avatar_url")
    val avatarUrl: String
)



