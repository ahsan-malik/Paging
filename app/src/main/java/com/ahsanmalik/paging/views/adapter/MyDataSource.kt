package com.ahsanmalik.paging.views.adapter

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ahsanmalik.paging.db.remote.MyApi
import com.ahsanmalik.paging.models.Dogs
import retrofit2.HttpException
import java.io.IOException

class MyDataSource(private val api: MyApi) : PagingSource<Int, Dogs>() {
    override fun getRefreshKey(state: PagingState<Int, Dogs>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Dogs> {

        return try {
            val page = params.key ?: 1
            //val response = api.getAnswers(page, 50, "stackoverflow")
            val response = api.getAllDogs(page, 20)
            LoadResult.Page(
                response,
                prevKey = if (page > 1) page - 1 else null,
                nextKey = if (response.isNotEmpty()) page + 1 else null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}

