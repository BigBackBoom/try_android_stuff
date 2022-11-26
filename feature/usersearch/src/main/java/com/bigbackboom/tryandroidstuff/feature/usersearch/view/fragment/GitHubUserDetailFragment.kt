package com.bigbackboom.tryandroidstuff.feature.usersearch.view.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bigbackboom.tryandroidstuff.feature.usersearch.databinding.FragmentGithubUserDetailBinding
import com.bigbackboom.tryandroidstuff.feature.usersearch.view.recycler.GitHubUserRepositoryRecyclerAdapter
import com.bigbackboom.tryandroidstuff.feature.usersearch.viewmodel.GitHubUserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GitHubUserDetailFragment : Fragment() {

    @Inject
    lateinit var adapter: GitHubUserRepositoryRecyclerAdapter

    @Inject
    lateinit var customTabsIntent: CustomTabsIntent

    lateinit var binding: FragmentGithubUserDetailBinding
    private val args: GitHubUserDetailFragmentArgs by navArgs()
    private val viewModel: GitHubUserDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGithubUserDetailBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = this@GitHubUserDetailFragment
            viewModel = this@GitHubUserDetailFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAppBar()
        initView()
        viewModel.fetchData(requireActivity(), args.login)
    }

    private fun initAppBar() {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity?)?.supportActionBar?.apply {
            title = args.login
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun initView() {
        binding.recyclerRepositoryList.apply {
            adapter = this@GitHubUserDetailFragment.adapter
            this@GitHubUserDetailFragment.adapter.setOnItemClickListener {
                val uri = Uri.parse(it)
                customTabsIntent.launchUrl(requireActivity(), uri)
            }
        }

        viewModel.repositoryItemList.observe(requireActivity()) {
            adapter.submitList(it)
        }
    }
}
