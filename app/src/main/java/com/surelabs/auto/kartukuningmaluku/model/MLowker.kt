package com.surelabs.auto.kartukuningmaluku.model

import com.surelabs.auto.kartukuningmaluku.network.NetworkModule
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.ResponseListLowker
import com.surelabs.auto.kartukuningmaluku.presenter.ILowkerPresenter
import com.surelabs.auto.kartukuningmaluku.view.ILowkerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MLowker(private var iLowkerView: ILowkerView?) : ILowkerPresenter {
    override fun getLowkerPadding(start: String?, limit: String?) {
        NetworkModule.getService().getListLowker(start, limit)
            .enqueue(object : Callback<ResponseListLowker> {
                override fun onFailure(call: Call<ResponseListLowker>, t: Throwable) {
                    iLowkerView?.onLowkerFailedLoad(t.message.toString())
                }

                override fun onResponse(
                    call: Call<ResponseListLowker>,
                    response: Response<ResponseListLowker>
                ) {
                    if (response.isSuccessful) {
                        val code = response.body()?.error
                        if (code == 200) {
                            iLowkerView?.onLowkerLoaded(response.body()?.data)
                        } else {
                            iLowkerView?.onLowkerFailedLoad(response.body()?.message, code)
                        }
                    } else {
                        iLowkerView?.onLowkerFailedLoad(
                            response.errorBody().toString(),
                            response.code()
                        )
                    }
                }

            })
    }
}