package com.example.rickandmorty.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.remote.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(

    private val repository: Repository
) : ViewModel() {

    fun fetchCharacters(page: Int) = repository.fetchCharacters(page)

}
