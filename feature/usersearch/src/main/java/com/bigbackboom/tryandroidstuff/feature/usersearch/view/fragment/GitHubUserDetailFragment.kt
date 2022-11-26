package com.bigbackboom.tryandroidstuff.feature.usersearch.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import com.bigbackboom.tryandroidstuff.feature.usersearch.databinding.FragmentGithubUserDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitHubUserDetailFragment : Fragment() {

    lateinit var binding: FragmentGithubUserDetailBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val args: GitHubUserDetailFragmentArgs by navArgs()

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
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAppBar()
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
