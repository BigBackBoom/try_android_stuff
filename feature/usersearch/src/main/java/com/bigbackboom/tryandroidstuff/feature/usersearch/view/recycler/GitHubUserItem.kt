package com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil

class GitHubUserItem(
    id: Int,
    name: String,
    userImageUrl: String,
) {
    private val _id = MutableLiveData(id.toString())
    val id: LiveData<String> = _id

    private val _name = MutableLiveData(name)
    val name: LiveData<String> = _name

    private val _userImageUrl = MutableLiveData(userImageUrl)
    val userImageUrl: LiveData<String> = _userImageUrl

    companion object {
        val itemCallback = object : DiffUtil.ItemCallback<GitHubUserItem>() {
            override fun areItemsTheSame(
                oldItem: GitHubUserItem,
                newItem: GitHubUserItem
            ): Boolean {
                return oldItem.id.value == newItem.id.value
            }

            override fun areContentsTheSame(
                oldItem: GitHubUserItem,
                newItem: GitHubUserItem
            ): Boolean {
                return oldItem.name.value == newItem.name.value &&
                    oldItem.userImageUrl.value == newItem.userImageUrl.value
            }
        }
    }
}


