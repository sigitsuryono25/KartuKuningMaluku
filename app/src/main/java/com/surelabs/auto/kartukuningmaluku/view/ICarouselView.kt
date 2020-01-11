package com.surelabs.auto.kartukuningmaluku.view

import com.surelabs.auto.kartukuningmaluku.network.datamodel.carousel.DataItem

interface ICarouselView {

    fun onCarouselLoaded(itemCarouselView: List<DataItem?>?)
    fun onCarouselFailedLoad(message: String?, code: Int? = 0)
}