package com.bigbackboom.tryandroidstuff.feature.usersearch.viewmodel

import androidx.lifecycle.ViewModel
import com.bigbackboom.tryandroidstuff.data.repository.GitHubSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GithubUserSearchViewModel @Inject constructor(
    gitHubSearchRepository: GitHubSearchRepository
): ViewModel(){
}
