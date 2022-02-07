package com.example.jtpcompvkladki.model

import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(
        @Query("page") pageNumber: Int,
        @Query("limit") limit: Int = 10
    ): List<Photo>
}