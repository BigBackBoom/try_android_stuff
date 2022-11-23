package com.bigbackboom.tryandroidstuff.data.datasource

import com.bigbackboom.tryandroidstuff.core.dispatcher.Dispatcher
import com.bigbackboom.tryandroidstuff.core.dispatcher.DispatcherType
import com.bigbackboom.tryandroidstuff.data.api.GitHubService
import com.bigbackboom.tryandroidstuff.model.UserResponse
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GithubRemoteDatasource @Inject constructor(
    @Dispatcher(DispatcherType.IO)
    private val ioDispatcher: CoroutineDispatcher,
    private val gitHubService: GitHubService
) {

    suspend fun getAuthors(
        query: String,
        page: Int
    ): UserResponse? = withContext(ioDispatcher) {
        val resp = gitHubService.getUsers(query, page)
        resp.body()
    }
}
