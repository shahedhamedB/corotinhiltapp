package com.example.hiltretrofit.retrofit.data.remote

import com.example.hiltretrofit.retrofit.service.MainSrevice
import javax.inject.Inject

class MainRemoteDataSourse @Inject constructor(
    private val  mainSrevice:MainSrevice
): BaseDataSource() {
    suspend fun getCategories( ) = getResult {

        mainSrevice.getAllCategories( ) }

}