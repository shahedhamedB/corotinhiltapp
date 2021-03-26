package com.example.hiltretrofit.retrofit.entites

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hiltretrofit.retrofit.entites.market.Item
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CategoryEntity(

    override var id: Int = 0,

    override var title: String = "",

    var logo: String? = "",

    var isSelected: Boolean = false
) : Item(), Parcelable
