package com.bigbackboom.tryandroidstuff.data.repository

import com.bigbackboom.tryandroidstuff.data.datasource.GithubRemoteDatasource
import com.bigbackboom.tryandroidstuff.data.datasource.Response
import com.bigbackboom.tryandroidstuff.model.UserDetail
import com.bigbackboom.tryandroidstuff.model.UserRepository
import com.bigbackboom.tryandroidstuff.model.UserResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GitHubSearchRepository @Inject constructor(
    private val remoteDatasource: GithubRemoteDatasource
): GitHubRepository {
    override fun searchUser(
        login: String,
        page: Int
    ): Flow<Response<UserResponse>> = flow {
        emit(remoteDatasource.searchUser(login, page))
    }

    override fun getUserDetail(login: String): Flow<Response<UserDetail>> = flow {
        emit(remoteDatasource.getUserDetail(login))
    }

    override fun getUserRepositoryList(login: String): Flow<Response<List<UserRepository>>> = flow {
        emit(remoteDatasource.getUserRepositoryList(login))
    }
}
