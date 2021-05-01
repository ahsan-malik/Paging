package com.ahsanmalik.paging.db.remote

import com.ahsanmalik.paging.models.Dogs
import com.ahsanmalik.paging.models.PassengerResponse
import com.ahsanmalik.paging.models.StackApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface MyApi {

    @GET("passenger")
    suspend fun getPassengerData(
        @Query("page") page:Int,
        @Query("size") size:Int = 10
    ):PassengerResponse

//    @Headers(
//        "Accept-Encoding: gzip,deflate,br",
//        "Content-Type: Application/Json",
//        "Accept: */*",
//        "User-Agent: Retrofit 2.9.0"
//    )
    @GET("answers")
    suspend fun getAnswers(
        @Query("page") page: Int,
        @Query("pagesize") pagesize: Int,
        @Query("site") site: String?
    ):StackApiResponse

    @GET("v1/images/search")
    suspend fun getAllDogs(
        @Query("page") page:Int,
        @Query("limit") limit:Int
    ):List<Dogs>


}