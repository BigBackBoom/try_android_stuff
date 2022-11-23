package com.bigbackboom.tryandroidstuff.feature.usersearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigbackboom.tryandroidstuff.core.dispatcher.Dispatcher
import com.bigbackboom.tryandroidstuff.core.dispatcher.DispatcherType
import com.bigbackboom.tryandroidstuff.data.repository.GitHubSearchRepository
import com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler.GitHubUserItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

@HiltViewModel
class GithubUserSearchViewModel @Inject constructor(
    @Dispatcher(DispatcherType.IO)
    private val mainDispatcher: CoroutineDispatcher,
    private val gitHubSearchRepository: GitHubSearchRepository
) : ViewModel() {

    companion object {
        // 好きなだけ読み込ませたらいつかはクラッシュするので100ページ以上は読み込まない
        private const val MAX_PAGE = 100
    }

    var keyword = ""
    private var page = 1

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isSearchEmpty = MutableLiveData(false)
    val isSearchEmpty: LiveData<Boolean> = _isSearchEmpty

    private val _userList = MutableLiveData<List<GitHubUserItem>>(listOf())
    val userList: LiveData<List<GitHubUserItem>> = _userList

    fun searchUser() {

        if (_isLoading.value == true || page > MAX_PAGE) {
            return
        }

        viewModelScope.launch(mainDispatcher) {
            _isLoading.postValue(true)
            gitHubSearchRepository.searchUser(keyword, page).collect {

                val temp = mutableListOf<GitHubUserItem>()
                _userList.value?.let { list ->
                    temp.addAll(list)
                }

                it.itemList.forEach { user ->
                    val item = GitHubUserItem(
                        user.id,
                        user.login,
                        user.avatarUrl
                    )
                    temp.add(item)
                }
                _userList.postValue(temp)
                _isSearchEmpty.postValue(temp.size <= 0)
                _isLoading.postValue(false)
                page++
            }
        }
    }

    fun clear() {
        _userList.postValue(listOf())
        page = 0
    }
}
