package com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil

class GitHubUserRepositoryItem(
    val id: Int,
    name: String?,
    val htmlUrl: String,
    description: String?,
    isFork: Boolean,
    language: String?,
    stargazersCount: Int
) {

    private val _name = MutableLiveData(name ?: "")
    val name: LiveData<String> = _name

    private val _isFork = MutableLiveData(isFork)
    val isFork: LiveData<Boolean> = _isFork

    private val _language = MutableLiveData(language ?: "")
    val language: LiveData<String> = _language

    private val _stargazersCount = MutableLiveData(stargazersCount.toString())
    val stargazersCount: LiveData<String> = _stargazersCount

    private val _description = MutableLiveData(description ?: "")
    val description: LiveData<String> = _description

    companion object {
        val itemCallback = object : DiffUtil.ItemCallback<GitHubUserRepositoryItem>() {
            override fun areItemsTheSame(
                oldItem: GitHubUserRepositoryItem,
                newItem: GitHubUserRepositoryItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: GitHubUserRepositoryItem,
                newItem: GitHubUserRepositoryItem
            ): Boolean {
                return oldItem.name.value == newItem.name.value &&
                    oldItem.isFork.value == newItem.isFork.value &&
                    oldItem.language.value == newItem.language.value &&
                    oldItem.stargazersCount.value == newItem.stargazersCount.value &&
                    oldItem.description.value == newItem.description.value
            }
        }
    }
}
