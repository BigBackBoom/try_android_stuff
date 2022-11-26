package com.bigbackboom.tryandroidstuff.data.repository

import com.bigbackboom.tryandroidstuff.model.UserDetail
import com.bigbackboom.tryandroidstuff.model.UserRepository
import com.bigbackboom.tryandroidstuff.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {
    fun searchUser(login: String, page: Int): Flow<UserResponse>

    fun getUserDetail(login: String): Flow<UserDetail>

    fun getUserRepositoryList(login: String): Flow<List<UserRepository>>

}
