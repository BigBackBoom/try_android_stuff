package com.bigbackboom.tryandroidstuff.feature.usersearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigbackboom.tryandroidstuff.data.repository.GitHubSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

@HiltViewModel
class GitHubUserDetailViewModel @Inject constructor(
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

    fun fetchData(login: String) {
        viewModelScope.launch {
            _isLoading.postValue(true)

            val defferUserDetail = async {
                getUserDetail(login)
            }
            listOf(defferUserDetail).awaitAll()

            _isLoading.postValue(false)
        }
    }

    private suspend fun getUserDetail(login: String) {
        gitHubSearchRepository.getUserDetail(login).collect {
            _imageUrl.postValue(it.avatarUrl)
            _login.postValue(it.login)
            _name.postValue(it.name)
            _following.postValue(it.following)
            _follower.postValue(it.followers)
        }
    }
}
