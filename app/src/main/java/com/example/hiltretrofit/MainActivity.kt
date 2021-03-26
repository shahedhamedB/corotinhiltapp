package com.example.hiltretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltretrofit.databinding.ActivityMainBinding
import com.example.hiltretrofit.main.MainAdapter
import com.example.hiltretrofit.main.MainViewHolder
import com.example.hiltretrofit.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel:MainViewHolder by viewModels()
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        instance = this

       adapter=MainAdapter(this)
        setupObservers()




    }

    private fun setupObservers() {
        viewModel.categoriesList.observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (it.data != null ) {
                        // binding.categoriesRv.adapter=MainAdapter(it.data.to)
                        //   adapter.setItems(it.data!!.toMutableList())
                        //   adapter.selectItems(viewModel.selectedCategoriesList)
                        /*  binding.categoriesRv.layoutManager =
                              GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
                          binding.categoriesRv.adapter = adapter


                          adapter.notifyDataSetChanged()*/

                        adapter.setItem(it.data.resultsData)
                        binding.categoriesRv.layoutManager =
                            GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
                        binding.categoriesRv.adapter = adapter
                        adapter.notifyDataSetChanged()


                    }

                }
                Resource.Status.ERROR ->
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setupRecyclerView() {

    }

    companion object {

        lateinit var instance: MainActivity


    }




}