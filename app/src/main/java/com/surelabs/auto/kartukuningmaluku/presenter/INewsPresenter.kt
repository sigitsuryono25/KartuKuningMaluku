package com.surelabs.auto.kartukuningmaluku.presenter

interface INewsPresenter {

    fun getOneLatestNews()
    fun getLatestNews()
    fun getLowker()
    fun getDetailNews(idNews: String?)
    fun getDetailLowker(idNews: String?)
    fun getNewsPadding(start: String?, limit: String?)
}