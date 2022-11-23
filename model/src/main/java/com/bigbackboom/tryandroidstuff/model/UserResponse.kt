package com.bigbackboom.tryandroidstuff.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    @Json(name = "total_count")
    val totalCount: Int,
    @Json(name = "items")
    val itemList: List<UserItem>,
)
