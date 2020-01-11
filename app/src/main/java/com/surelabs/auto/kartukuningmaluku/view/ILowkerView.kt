package com.surelabs.auto.kartukuningmaluku.view

import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.DataItem

interface ILowkerView {
    fun onLowkerLoaded(itemLowker: List<DataItem?>?)
    fun onLowkerFailedLoad(message: String?, code: Int? = 0)
}