package com.example.hiltretrofit.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.hiltretrofit.retrofit.data.repository.MainRepository
import com.example.hiltretrofit.retrofit.entites.CategoryEntity

class MainViewHolder @ViewModelInject constructor(
    private val repository: MainRepository
):ViewModel() {
    val categoriesList = repository.getCategories()


}