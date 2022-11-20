package com.bigbackboom.tryandroidstuff.data.repository

import com.bigbackboom.tryandroidstuff.data.datasource.GithubRemoteDatasource
import javax.inject.Inject


class GitHubSearchRepository @Inject constructor(
    remoteDatasource: GithubRemoteDatasource
): GitHubRepository {
    fun searchUser(keyword: String) {

    }
}
