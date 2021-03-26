package com.example.hiltretrofit.main

import android.content.Context
import android.view.ViewGroup

import androidx.core.content.ContextCompat
import com.example.hiltretrofit.MainActivity
import com.example.hiltretrofit.core.BaseAdapter
import com.example.hiltretrofit.core.BaseBindingViewHolder
import com.example.hiltretrofit.databinding.RowSubCategoryBinding

import com.example.hiltretrofit.retrofit.entites.market.ResultsData


class MainAdapter (
    private val mContext: Context

) : BaseAdapter<ResultsData, MainAdapter.ViewHolder>(){

    fun setItem(items: MutableList<ResultsData>){
        this.items?.clear()
        this.items?.addAll(items)
        notifyDataSetChanged()


    }

    override fun getViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RowSubCategoryBinding.inflate(inflater, parent, false))


    inner class ViewHolder(val binding: RowSubCategoryBinding) : BaseBindingViewHolder<ResultsData>(binding) {
        override fun bind(position: Int, item: ResultsData?) {
            bind<RowSubCategoryBinding> {
                this.model =item
            }
            binding.executePendingBindings()


        }

    }


}

