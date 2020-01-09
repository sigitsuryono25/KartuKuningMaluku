package com.surelabs.auto.kartukuningmaluku.network

import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.ResponseListLowker
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news.ResponseListNews
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("services/get_berita")
    fun getNews(): Call<ResponseListNews>

    @GET("services/get_lowker")
    fun getLowker(): Call<ResponseListLowker>
}
