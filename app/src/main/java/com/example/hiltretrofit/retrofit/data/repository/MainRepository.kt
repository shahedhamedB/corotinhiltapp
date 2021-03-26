package com.example.hiltretrofit.retrofit.data.repository

import com.example.hiltretrofit.retrofit.data.remote.MainRemoteDataSourse

import com.example.hiltretrofit.utils.performRemoteOperation
import javax.inject.Inject

class MainRepository @Inject constructor(
private val mainRemoteDataSourse: MainRemoteDataSourse
) {
    fun getCategories() = performRemoteOperation (

        networkCall = { mainRemoteDataSourse.getCategories() }


    )

}