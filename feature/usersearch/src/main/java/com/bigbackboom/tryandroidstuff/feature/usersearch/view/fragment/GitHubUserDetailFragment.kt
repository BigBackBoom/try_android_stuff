package com.bigbackboom.tryandroidstuff.feature.usersearch.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bigbackboom.tryandroidstuff.feature.usersearch.databinding.FragmentGithubUserDetailBinding
import com.bigbackboom.tryandroidstuff.feature.usersearch.viewmodel.GitHubUserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitHubUserDetailFragment : Fragment() {

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
        viewModel.fetchData(args.login)
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
}
