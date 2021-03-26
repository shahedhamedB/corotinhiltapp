package com.example.task_ui.data.model.home

import com.example.hiltretrofit.retrofit.entites.market.ResultsData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoriesWrapper (

    @SerializedName("status")
    @Expose
    var statusData: StatusData,
    @SerializedName("results")
    @Expose
    var resultsData: ArrayList<ResultsData>

    )