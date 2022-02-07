package com.example.jtpcompvkladki.model

class IPhotoRepository (private val apiService: PhotoApiService) : PhotoRepository{
    override suspend fun getPhotos(page: Int): List<Photo> {
        return apiService.getPhotos(page)
    }

}