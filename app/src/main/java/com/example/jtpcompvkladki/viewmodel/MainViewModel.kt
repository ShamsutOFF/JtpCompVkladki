package com.example.jtpcompvkladki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jtpcompvkladki.model.IPhotoRepository
import com.example.jtpcompvkladki.model.Photo
import com.example.jtpcompvkladki.model.PhotoSource
import kotlinx.coroutines.flow.Flow

class MainViewModel (photoRepository: IPhotoRepository) : ViewModel() {
    val photos: Flow<PagingData<Photo>> = Pager(PagingConfig(pageSize = 20)){
        PhotoSource(photoRepository)
    }.flow
}