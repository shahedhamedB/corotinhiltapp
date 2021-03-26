package com.example.hiltretrofit.retrofit.service

import com.example.task_ui.data.model.home.CategoriesWrapper
import retrofit2.Response
import retrofit2.http.GET

interface MainSrevice {

    @GET("categories")
    suspend fun getAllCategories() : Response<CategoriesWrapper>

}