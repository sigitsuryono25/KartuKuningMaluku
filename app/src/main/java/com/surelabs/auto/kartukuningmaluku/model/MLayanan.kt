package com.surelabs.auto.kartukuningmaluku.model

import com.surelabs.auto.kartukuningmaluku.network.NetworkModule
import com.surelabs.auto.kartukuningmaluku.network.datamodel.detail.layanan.ResponseDetailLayanan
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.kategorilayanan.ResponseKategori
import com.surelabs.auto.kartukuningmaluku.presenter.ILayananPresenter
import com.surelabs.auto.kartukuningmaluku.view.ILayananView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MLayanan(private var iLayananView: ILayananView) : ILayananPresenter {
    override fun getListKategoriLayanan() {
        NetworkModule.getService().getListLayanan()
            .enqueue(object : Callback<ResponseKategori> {
                override fun onFailure(call: Call<ResponseKategori>, t: Throwable) {
                    iLayananView.onLayananFailedLoad(t.message)
                }

                override fun onResponse(
                    call: Call<ResponseKategori>,
                    response: Response<ResponseKategori>
                ) {
                    if (response.isSuccessful) {
                        val code = response.body()?.error
                        if (code == 200) {
                            iLayananView.onLayananLoaded(response.body()?.data)
                        } else {
                            iLayananView.onLayananFailedLoad(response.body()?.message, code)
                        }
                    } else {
                        iLayananView.onLayananFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }

    override fun getContentLayanan(idLayanan: String?) {
        NetworkModule.getService().getDetailLayanan(idLayanan)
            .enqueue(object : Callback<ResponseDetailLayanan> {
                override fun onFailure(call: Call<ResponseDetailLayanan>, t: Throwable) {
                    iLayananView.onLayananFailedLoad(t.message)
                }

                override fun onResponse(
                    call: Call<ResponseDetailLayanan>,
                    response: Response<ResponseDetailLayanan>
                ) {
                    if (response.isSuccessful) {
                        val code = response.body()?.error
                        if (code == 200) {
                            iLayananView.onDetailLayananLoaded(response.body()?.data)
                        } else {
                            iLayananView.onLayananFailedLoad(response.body()?.message, code)
                        }
                    } else {
                        iLayananView.onLayananFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }
}