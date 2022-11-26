package com.bigbackboom.tryandroidstuff.feature.usersearch.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigbackboom.tryandroidstuff.data.repository.GitHubSearchRepository
import com.bigbackboom.tryandroidstuff.feature.usersearch.R
import com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler.GitHubUserRepositoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@HiltViewModel
class GitHubUserDetailViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val gitHubSearchRepository: GitHubSearchRepository
) : ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isSearchEmpty = MutableLiveData(false)
    val isSearchEmpty: LiveData<Boolean> = _isSearchEmpty

    private val _imageUrl = MutableLiveData("")
    val imageUrl: LiveData<String> = _imageUrl

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _login = MutableLiveData("")
    val login: LiveData<String> = _login

    private val _follower = MutableLiveData(0)
    val follower: LiveData<Int> = _follower

    private val _following = MutableLiveData(0)
    val following: LiveData<Int> = _following

    private val _repositoryItemList = MutableLiveData(listOf<GitHubUserRepositoryItem>())
    val repositoryItemList: LiveData<List<GitHubUserRepositoryItem>> = _repositoryItemList

    fun fetchData(context: Context, login: String) {
        viewModelScope.launch {
            _isLoading.postValue(true)

            val defferUserDetail = async {
                getUserDetail(context, login)
            }

            val defferUserRepository = async {
                getUserRepositoryList(context, login)
            }

            listOf(defferUserDetail, defferUserRepository).awaitAll()

            _isLoading.postValue(false)
        }
    }

    private suspend fun getUserDetail(context: Context, login: String) {
        gitHubSearchRepository.getUserDetail(login).collect {

            val name = if (!it.name.isNullOrBlank()) {
                it.name
            } else {
                context.getString(R.string.user_detail_name_unavailable)
            }

            _imageUrl.postValue(it.avatarUrl)
            _login.postValue(it.login)
            _name.postValue(name)
            _following.postValue(it.following)
            _follower.postValue(it.followers)
        }
    }

    private suspend fun getUserRepositoryList(context: Context, login: String) {
        gitHubSearchRepository.getUserRepositoryList(login).map {
            val temp = mutableListOf<GitHubUserRepositoryItem>()
            it.filter { repo ->
                // ForkしたRepositoryは弾く
                !repo.isFork
            }.forEach { repo ->

                val language = if (!repo.language.isNullOrBlank()) {
                    repo.language
                } else {
                    context.getString(R.string.user_detail_language_unavailable)
                }

                val item = GitHubUserRepositoryItem(
                    repo.id,
                    repo.name,
                    repo.htmlUrl,
                    repo.description,
                    repo.isFork,
                    language,
                    repo.stargazersCount
                )
                temp.add(item)
            }
            temp.toList()
        }.collect {
            _repositoryItemList.postValue(it)
        }
    }
}
