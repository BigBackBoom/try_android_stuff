package com.bigbackboom.tryandroidstuff.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserItem(
    val id: Int,
    val login: String,
    @Json(name = "avatar_url")
    val avatarUrl: String
)



