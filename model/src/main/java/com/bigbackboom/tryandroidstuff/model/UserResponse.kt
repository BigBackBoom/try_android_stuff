package com.bigbackboom.tryandroidstuff.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("items")
    val itemList: List<UserItem>,
)
