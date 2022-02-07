package com.example.jtpcompvkladki.di

import com.example.jtpcompvkladki.model.IPhotoRepository
import com.example.jtpcompvkladki.model.PhotoApiService
import org.koin.dsl.module

val repositoryModule = module {
    single { createRepository(get()) }
}

fun createRepository(
    photoApi: PhotoApiService
) : IPhotoRepository = IPhotoRepository(photoApi)