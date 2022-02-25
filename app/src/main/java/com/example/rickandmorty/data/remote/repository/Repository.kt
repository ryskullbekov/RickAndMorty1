package com.example.rickandmorty.data.remote.repository

import android.util.Log
import androidx.lifecycle.liveData
import com.example.rickandmorty.common.Resource
import com.example.rickandmorty.data.remote.apiService.ApiService
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class Repository @Inject constructor(


    private val service: ApiService
) {
    fun fetchCharacters(page: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            Log.e("tag", service.fetchCharacters(page).toString())
            emit(Resource.Success(service.fetchCharacters(page)))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error !", null))
        }
    }
}