package com.bigbackboom.tryandroidstuff.data.datasource

import com.bigbackboom.tryandroidstuff.core.dispatcher.Dispatcher
import com.bigbackboom.tryandroidstuff.core.dispatcher.DispatcherType
import com.bigbackboom.tryandroidstuff.data.api.GitHubService
import com.bigbackboom.tryandroidstuff.model.UserDetail
import com.bigbackboom.tryandroidstuff.model.UserRepository
import com.bigbackboom.tryandroidstuff.model.UserResponse
import java.net.HttpURLConnection.HTTP_OK
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GithubRemoteDatasource @Inject constructor(
    @Dispatcher(DispatcherType.IO)
    private val ioDispatcher: CoroutineDispatcher,
    private val gitHubService: GitHubService
) {

    suspend fun searchUser(
        query: String,
        page: Int
    ): Response<UserResponse> = withContext(ioDispatcher) {
        val resp = gitHubService.searchUser(query, page)

        val data = resp.body()
        if (resp.code() == HTTP_OK && data != null) {
            ResponseSuccess(data)
        } else {
            ResponseError(resp.code(), resp.message())
        }
    }

    suspend fun getUserDetail(
        login: String
    ): Response<UserDetail> = withContext(ioDispatcher) {
        val resp = gitHubService.getUsrDetail(login)

        val data = resp.body()
        if (resp.code() == HTTP_OK && data != null) {
            ResponseSuccess(data)
        } else {
            ResponseError(resp.code(), resp.message())
        }
    }

    suspend fun getUserRepositoryList(
        login: String
    ): Response<List<UserRepository>> = withContext(ioDispatcher) {
        val resp = gitHubService.getUsrRepositoryList(login)

        val data = resp.body()
        if (resp.code() == HTTP_OK && data != null) {
            ResponseSuccess(data)
        } else {
            ResponseError(resp.code(), resp.message())
        }
    }
}
