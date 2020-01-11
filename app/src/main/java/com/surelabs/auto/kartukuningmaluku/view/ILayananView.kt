package com.surelabs.auto.kartukuningmaluku.view

import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.kategorilayanan.DataItem

interface ILayananView {
    fun onLayananLoaded(itemLayanan: List<DataItem?>?)
    fun onLayananFailedLoad(message: String?, code: Int? = 0)
    fun onDetailLayananLoaded(itemDetail: List<com.surelabs.auto.kartukuningmaluku.network.datamodel.detail.layanan.DataItem?>?)
}