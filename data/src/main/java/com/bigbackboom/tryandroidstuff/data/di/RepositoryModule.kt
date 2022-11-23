package com.bigbackboom.tryandroidstuff.data.di

import com.bigbackboom.tryandroidstuff.data.repository.GitHubRepository
import com.bigbackboom.tryandroidstuff.data.repository.GitHubSearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindGitHubSearchRepository(
        gitHubSearchRepository: GitHubSearchRepository
    ): GitHubRepository

}
