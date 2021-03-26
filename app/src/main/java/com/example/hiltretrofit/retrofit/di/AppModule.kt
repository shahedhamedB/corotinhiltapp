package com.example.hiltretrofit.retrofit.di

import android.app.Application
import androidx.room.Room
import com.example.hiltretrofit.retrofit.data.remote.MainRemoteDataSourse
import com.example.hiltretrofit.retrofit.service.MainSrevice
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("http://www.talabyeh.com/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()
    @Provides
    fun provideMainService(retrofit: Retrofit): MainSrevice = retrofit.create(MainSrevice::class.java)

    @Singleton
    @Provides
    fun provideMainRemoteDataSource(mainSrevice: MainSrevice) =
        MainRemoteDataSourse(mainSrevice)


}
