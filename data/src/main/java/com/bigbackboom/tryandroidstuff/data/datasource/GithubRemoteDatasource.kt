package com.bigbackboom.tryandroidstuff.data.datasource

import com.bigbackboom.tryandroidstuff.core.dispatcher.Dispatcher
import com.bigbackboom.tryandroidstuff.core.dispatcher.DispatcherType
import com.bigbackboom.tryandroidstuff.data.api.GitHubService
import com.bigbackboom.tryandroidstuff.model.UserDetail
import com.bigbackboom.tryandroidstuff.model.UserResponse
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
    ): UserResponse? = withContext(ioDispatcher) {
        val resp = gitHubService.searchUser(query, page)
        resp.body()
    }

    suspend fun getUserDetail(
        login: String
    ): UserDetail? = withContext(ioDispatcher) {
        val resp = gitHubService.getUsrDetail(login)
        resp.body()
    }
}
