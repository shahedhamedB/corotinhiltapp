package com.example.hiltretrofit.retrofit.entites

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class StatusEntity: Parcelable {
    var message:String?=""
        get() = field
        set(value) {
            field = value
        }
    var code:Int?=400
        get() = field
        set(value) {
            field = value
        }
}