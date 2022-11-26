package com.bigbackboom.tryandroidstuff.feature.usersearch.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bigbackboom.tryandroidstuff.feature.usersearch.databinding.FragmentGithubUserSearchBinding
import com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler.GitHubUserRecyclerAdapter
import com.bigbackboom.tryandroidstuff.feature.usersearch.viewmodel.GithubUserSearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import timber.log.Timber


@AndroidEntryPoint
class GithubUserSearchFragment : Fragment() {

    @Inject
    lateinit var adapter: GitHubUserRecyclerAdapter

    lateinit var binding: FragmentGithubUserSearchBinding
    private val viewModel: GithubUserSearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGithubUserSearchBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = this@GithubUserSearchFragment
            viewModel = this@GithubUserSearchFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        // 一覧設定
        viewModel.userList.observe(requireActivity()) {
            adapter.submitList(it)
        }
        adapter.setOnItemClickListener {
            val action = GithubUserSearchFragmentDirections
                .actionGithubUserSearchFragmentToGitHubUserDetailFragment(
                    it
                )
            findNavController().navigate(action)
        }
        binding.recyclerUserList.adapter = adapter

        val scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    viewModel.searchUser()
                    Timber.d("scrolled to bottom")
                }
            }
        }

        // 検索
        binding.searchKeyword.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(keyword: String?): Boolean {
                Timber.d("Text Submit")

                // 結果を一度クリア
                binding.recyclerUserList.removeOnScrollListener(scrollListener)
                viewModel.clear()

                if (!keyword.isNullOrBlank()) {
                    // 文字があった場合は検索と自動ページングを行う
                    viewModel.keyword = keyword
                    viewModel.searchUser()
                    binding.recyclerUserList.addOnScrollListener(scrollListener)
                }

                return false
            }

            override fun onQueryTextChange(keyword: String?): Boolean {
                Timber.d("Text Changed")
                return false
            }
        })
        binding.searchKeyword.setOnCloseListener {
            binding.recyclerUserList.removeOnScrollListener(scrollListener)
            viewModel.clear()
            false
        }
    }
}
