package com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bigbackboom.tryandroidstuff.feature.usersearch.R
import com.bigbackboom.tryandroidstuff.feature.usersearch.databinding.ItemGithubUserRepositoryBinding
import com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler.GitHubUserRepositoryRecyclerAdapter.BindingHolder
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject


class GitHubUserRepositoryRecyclerAdapter @Inject constructor(
    @ActivityContext private val context: Context
) : ListAdapter<GitHubUserRepositoryItem, BindingHolder>(
    GitHubUserRepositoryItem.itemCallback
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemGithubUserRepositoryBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_github_user_repository,
                parent,
                false
            )

        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val binding: ItemGithubUserRepositoryBinding = holder.binding
        val item: GitHubUserRepositoryItem = getItem(position)

        if (context is AppCompatActivity) {
            binding.lifecycleOwner = context
            binding.root.setOnClickListener {

            }
        }
        binding.item = item
    }

    class BindingHolder(
        val binding: ItemGithubUserRepositoryBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
