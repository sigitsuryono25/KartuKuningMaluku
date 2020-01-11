package com.surelabs.auto.kartukuningmaluku.model

import android.content.Context
import com.surelabs.auto.kartukuningmaluku.network.NetworkModule
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.ResponseListLowker
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news.ResponseListNews
import com.surelabs.auto.kartukuningmaluku.presenter.INewsPresenter
import com.surelabs.auto.kartukuningmaluku.view.INewsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MNews(private val context: Context?, private val mINewsView: INewsView) : INewsPresenter {
    override fun getOneLatestNews() {
        NetworkModule.getService().getOneLatesNews()
            .enqueue(object : Callback<ResponseListNews> {
                override fun onFailure(call: Call<ResponseListNews>, t: Throwable) {
                    mINewsView.onOneLatestNewsFailedLoad(t.message.toString())
                }

                override fun onResponse(
                    call: Call<ResponseListNews>,
                    response: Response<ResponseListNews>
                ) {
                    if (response.isSuccessful) {
                        val error = response.body()?.error
                        if (error == 200) {
                            mINewsView.onOneLatestNewsLoaded(response.body()?.data)
                        } else {
                            mINewsView.onOneLatestNewsFailedLoad(response.body()?.message, error)
                        }
                    } else {
                        mINewsView.onOneLatestNewsFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }

    override fun getLatestNews() {
        NetworkModule.getService().getNews()
            .enqueue(object : Callback<ResponseListNews> {
                override fun onFailure(call: Call<ResponseListNews>, t: Throwable) {
                    mINewsView.onNewsFailedLoad(t.message.toString())
                }

                override fun onResponse(
                    call: Call<ResponseListNews>,
                    response: Response<ResponseListNews>
                ) {
                    if (response.isSuccessful) {
                        val error = response.body()?.error
                        if (error == 200) {
                            mINewsView.onNewsLoaded(response.body()?.data)
                        } else {
                            mINewsView.onNewsFailedLoad(response.body()?.message, error)
                        }
                    } else {
                        mINewsView.onNewsFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }

    override fun getLowker() {
        NetworkModule.getService().getLowker()
            .enqueue(object : Callback<ResponseListLowker> {
                override fun onFailure(call: Call<ResponseListLowker>, t: Throwable) {
                    mINewsView.onLowkerFailedLoad(t.message.toString())
                }

                override fun onResponse(
                    call: Call<ResponseListLowker>,
                    response: Response<ResponseListLowker>
                ) {
                    if (response.isSuccessful) {
                        val error = response.body()?.error
                        if (error == 200) {
                            mINewsView.onLowkerLoaded(response.body()?.data)
                        } else {
                            mINewsView.onLowkerFailedLoad(response.body()?.message, error)
                        }
                    } else {
                        mINewsView.onLowkerFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }

    override fun getDetailNews(idNews: String?) {
        NetworkModule.getService().getDetailNews(idNews)
            .enqueue(object : Callback<ResponseListNews> {
                override fun onFailure(call: Call<ResponseListNews>, t: Throwable) {
                    mINewsView.onNewsFailedLoad(t.message.toString())
                }

                override fun onResponse(
                    call: Call<ResponseListNews>,
                    response: Response<ResponseListNews>
                ) {
                    if (response.isSuccessful) {
                        val error = response.body()?.error
                        if (error == 200) {
                            mINewsView.onNewsLoaded(response.body()?.data)
                        } else {
                            mINewsView.onNewsFailedLoad(response.body()?.message, error)
                        }
                    } else {
                        mINewsView.onNewsFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }

    override fun getDetailLowker(idNews: String?) {
        NetworkModule.getService().getDetailLowker(idNews)
            .enqueue(object : Callback<ResponseListLowker> {
                override fun onFailure(call: Call<ResponseListLowker>, t: Throwable) {
                    mINewsView.onLowkerFailedLoad(t.message.toString())
                }

                override fun onResponse(
                    call: Call<ResponseListLowker>,
                    response: Response<ResponseListLowker>
                ) {
                    if (response.isSuccessful) {
                        val error = response.body()?.error
                        if (error == 200) {
                            mINewsView.onLowkerLoaded(response.body()?.data)
                        } else {
                            mINewsView.onLowkerFailedLoad(response.body()?.message, error)
                        }
                    } else {
                        mINewsView.onLowkerFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }

    override fun getNewsPadding(start: String?, limit: String?) {
        NetworkModule.getService().getBeritaPadding(start, limit)
            .enqueue(object : Callback<ResponseListNews> {
                override fun onFailure(call: Call<ResponseListNews>, t: Throwable) {
                    mINewsView.onNewsFailedLoad(t.message.toString())
                }

                override fun onResponse(
                    call: Call<ResponseListNews>,
                    response: Response<ResponseListNews>
                ) {
                    if (response.isSuccessful) {
                        val error = response.body()?.error
                        if (error == 200) {
                            mINewsView.onNewsLoaded(response.body()?.data)
                        } else {
                            mINewsView.onNewsFailedLoad(response.body()?.message, error)
                        }
                    } else {
                        mINewsView.onNewsFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }
}