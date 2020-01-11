package com.surelabs.auto.kartukuningmaluku.network

import com.surelabs.auto.kartukuningmaluku.network.datamodel.carousel.ResponseCarousel
import com.surelabs.auto.kartukuningmaluku.network.datamodel.detail.layanan.ResponseDetailLayanan
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.kategorilayanan.ResponseKategori
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.ResponseListLowker
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news.ResponseListNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("services/get_berita")
    fun getNews(): Call<ResponseListNews>

    @GET("services/get_latest_one_news")
    fun getOneLatesNews(): Call<ResponseListNews>

    @GET("services/detail_news/{id}")
    fun getDetailNews(@Path("id") id: String?): Call<ResponseListNews>

    @GET("services/get_lowker")
    fun getLowker(): Call<ResponseListLowker>

    @GET("services/detail_lowker/{id}")
    fun getDetailLowker(@Path("id") id: String?): Call<ResponseListLowker>

    @GET("services/get_lowker_padding/{start}/{limit}")
    fun getListLowker(@Path("start") start: String? = "0", @Path("limit") limit: String? = "10"): Call<ResponseListLowker>

    @GET("services/get_carousel")
    fun getCarousel(): Call<ResponseCarousel>

    @GET("services/get_berita_padding/{start}/{limit}")
    fun getBeritaPadding(@Path("start") start: String?, @Path("limit") limit: String?): Call<ResponseListNews>

    @GET("services/get_kat_layanan")
    fun getListLayanan(): Call<ResponseKategori>


    @GET("services/get_detail_layanan/{idLayanan}")
    fun getDetailLayanan(@Path("idLayanan") idLayanan: String?): Call<ResponseDetailLayanan>

}
