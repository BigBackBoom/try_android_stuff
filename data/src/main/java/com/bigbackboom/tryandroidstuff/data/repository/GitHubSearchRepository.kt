package com.bigbackboom.tryandroidstuff.data.repository

import com.bigbackboom.tryandroidstuff.data.datasource.GithubRemoteDatasource
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
    ): Flow<UserResponse> = flow {
        remoteDatasource.searchUser(login, page)?.let {
            emit(it)
        }
    }

    override fun getUserDetail(login: String): Flow<UserDetail> = flow {
        remoteDatasource.getUserDetail(login)?.let {
            emit(it)
        }
    }

    override fun getUserRepositoryList(login: String): Flow<List<UserRepository>> = flow {
        remoteDatasource.getUserRepositoryList(login)?.let {
            emit(it)
        }
    }
}
