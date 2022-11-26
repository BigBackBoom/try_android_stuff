package com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bigbackboom.tryandroidstuff.feature.usersearch.R
import com.bigbackboom.tryandroidstuff.feature.usersearch.databinding.ItemGithubUserBinding
import com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler.GitHubUserRecyclerAdapter.BindingHolder
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class GitHubUserRecyclerAdapter @Inject constructor(
    @ActivityContext private val context: Context
) : ListAdapter<GitHubUserItem, BindingHolder>(
    GitHubUserItem.itemCallback
) {
    private var itemListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemGithubUserBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_github_user,
                parent,
                false
            )

        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val binding: ItemGithubUserBinding = holder.binding
        val item: GitHubUserItem = getItem(position)

        if (context is AppCompatActivity) {
            binding.lifecycleOwner = context
            binding.root.setOnClickListener {
                itemListener?.invoke(item.name.value ?: "")
            }
        }
        binding.item = item
    }

    fun setOnItemClickListener(listener: (String) -> Unit) {
        itemListener = listener
    }

    class BindingHolder(
        val binding: ItemGithubUserBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
