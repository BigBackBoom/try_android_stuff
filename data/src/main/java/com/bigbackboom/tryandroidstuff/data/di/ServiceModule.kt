package com.bigbackboom.tryandroidstuff.data.di

import android.content.Context
import com.bigbackboom.tryandroidstuff.core.network.GithubClient
import com.bigbackboom.tryandroidstuff.data.api.GitHubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class ServiceModule {

    @Provides
    fun provideGitHubService(
        @GithubClient retrofit: Retrofit
    ): GitHubService {
        return retrofit.create(GitHubService::class.java)
    }
}
