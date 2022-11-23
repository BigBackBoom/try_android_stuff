package com.bigbackboom.tryandroidstuff.feature.usersearch.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.bigbackboom.tryandroidstuff.feature.usersearch.R
import com.bigbackboom.tryandroidstuff.feature.usersearch.databinding.ActivityGithubUserSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitHubUserSearchActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityGithubUserSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGithubUserSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_content_main
        ) as NavHostFragment
        appBarConfiguration = AppBarConfiguration(navHostFragment.navController.graph)
    }
}
