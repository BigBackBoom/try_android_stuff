package com.bigbackboom.tryandroidstuff.data.api

import com.bigbackboom.tryandroidstuff.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {

    @GET("/search/users")
    suspend fun getUsers(
        @Query("q") query: String,
        @Query("page") page: Int
    ): Response<UserResponse>

}
