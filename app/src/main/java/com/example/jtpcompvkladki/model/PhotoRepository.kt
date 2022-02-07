package com.example.jtpcompvkladki.model

interface PhotoRepository {
    suspend fun getPhotos(page: Int) : List<Photo>
}