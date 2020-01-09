package com.surelabs.auto.kartukuningmaluku.dashboard.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.home.adapter.AdapterHomeLowker
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.home.adapter.AdapterHomeNews
import com.surelabs.auto.kartukuningmaluku.network.NetworkModule
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.ResponseListLowker
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news.ResponseListNews
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getNews()
        getLowker()
        shimmer_view_containerlowker.startShimmerAnimation()
        shimmer_view_containernews.startShimmerAnimation()
    }

    private fun getNews() {
        NetworkModule.getService().getNews()
            .enqueue(object : Callback<ResponseListNews> {
                override fun onFailure(call: Call<ResponseListNews>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseListNews>,
                    response: Response<ResponseListNews>
                ) {
                    if (response.isSuccessful) {
                        val error = response.body()?.error
                        if (error == 200) {
                            val data = response.body()?.data
                            val adapter = AdapterHomeNews(data) {
                                toast(it?.judul.toString())
                            }

                            rcBerita.adapter = adapter
                            shimmer_view_containernews.stopShimmerAnimation()
                            shimmer_view_containernews.visibility = View.GONE
                        }
                    } else {

                    }
                }

            })
    }

    private fun getLowker() {
        NetworkModule.getService().getLowker()
            .enqueue(object : Callback<ResponseListLowker> {
                override fun onFailure(call: Call<ResponseListLowker>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseListLowker>,
                    response: Response<ResponseListLowker>
                ) {
                    if (response.isSuccessful) {
                        val error = response.body()?.error
                        if (error == 200) {
                            val data = response.body()?.data
                            val adapter = AdapterHomeLowker(data) {
                                toast(it?.judul.toString())
                            }

                            rcLowker.adapter = adapter
                            shimmer_view_containerlowker.stopShimmerAnimation()
                            shimmer_view_containerlowker.visibility = View.GONE
                        }
                    } else {

                    }
                }

            })
    }

}
