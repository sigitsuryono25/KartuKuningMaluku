package com.surelabs.auto.kartukuningmaluku.model

import com.surelabs.auto.kartukuningmaluku.network.NetworkModule
import com.surelabs.auto.kartukuningmaluku.network.datamodel.carousel.ResponseCarousel
import com.surelabs.auto.kartukuningmaluku.presenter.ICarouselPresenter
import com.surelabs.auto.kartukuningmaluku.view.ICarouselView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MCarousel(private var iCarouselView: ICarouselView) : ICarouselPresenter {
    override fun getCarouselView() {
        NetworkModule.getService().getCarousel()
            .enqueue(object : Callback<ResponseCarousel> {
                override fun onFailure(call: Call<ResponseCarousel>, t: Throwable) {
                    iCarouselView.onCarouselFailedLoad(t.message)
                }

                override fun onResponse(
                    call: Call<ResponseCarousel>,
                    response: Response<ResponseCarousel>
                ) {
                    if (response.isSuccessful) {
                        val code = response.body()?.error
                        if (code == 200) {
                            iCarouselView.onCarouselLoaded(response.body()?.data)
                        } else {
                            iCarouselView.onCarouselFailedLoad(response.body()?.message, code)
                        }
                    } else {
                        iCarouselView.onCarouselFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }
}