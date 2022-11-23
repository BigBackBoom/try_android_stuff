package com.bigbackboom.tryandroidstuff.data.repository

import com.bigbackboom.tryandroidstuff.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {
    fun searchUser(userName: String): Flow<UserResponse?>
}
