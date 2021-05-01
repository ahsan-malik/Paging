package com.ahsanmalik.paging.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ahsanmalik.paging.db.Repository
import com.ahsanmalik.paging.db.remote.MyApi
import com.ahsanmalik.paging.models.Dogs
import com.ahsanmalik.paging.models.Item
import com.ahsanmalik.paging.models.Passenger
import com.ahsanmalik.paging.views.adapter.MyDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: Repository): ViewModel() {


    /*val getAllDogs: Flow<PagingData<Dogs>> = Pager(config = PagingConfig(20,enablePlaceholders = false)){
        MyDataSource(repository.apiService)
    }.flow.cachedIn(viewModelScope)*/

    /*val passenger = Pager(PagingConfig(10)){
        MyDataSource(api)
    }.flow.cachedIn(viewModelScope)*/

    val getAll: Flow<PagingData<Dogs>> = Pager(config =  PagingConfig(20, enablePlaceholders = false)){
        MyDataSource(repository.apiService)
    }.flow.cachedIn(viewModelScope)

}