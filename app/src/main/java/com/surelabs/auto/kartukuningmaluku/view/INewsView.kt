package com.surelabs.auto.kartukuningmaluku.view

import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news.DataItem

interface INewsView {
    fun onNewsLoaded(itemNews: List<DataItem?>?)
    fun onNewsFailedLoad(message: String?, code: Int? = 0)
    fun onLowkerLoaded(itemLowker: List<com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.DataItem?>?)
    fun onLowkerFailedLoad(message: String?, code: Int? = 0)
    fun onOneLatestNewsLoaded(itemNews: List<DataItem?>?)
    fun onOneLatestNewsFailedLoad(message: String?, code: Int? = 0)
}