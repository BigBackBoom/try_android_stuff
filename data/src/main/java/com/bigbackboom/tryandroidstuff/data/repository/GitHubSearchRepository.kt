package com.bigbackboom.tryandroidstuff.data.repository

import com.bigbackboom.tryandroidstuff.data.datasource.GithubRemoteDatasource
import com.bigbackboom.tryandroidstuff.model.UserResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GitHubSearchRepository @Inject constructor(
    private val remoteDatasource: GithubRemoteDatasource
): GitHubRepository {
    override fun searchUser(
        userName: String,
        page: Int
    ): Flow<UserResponse> = flow {
        val formattedQuery = "${userName}"
        remoteDatasource.getAuthors(formattedQuery, page)?.let {
            emit(it)
        }
    }
}
