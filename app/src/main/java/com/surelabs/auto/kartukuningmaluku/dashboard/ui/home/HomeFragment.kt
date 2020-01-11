package com.surelabs.auto.kartukuningmaluku.dashboard.ui.home


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.berita.BeritaFragment
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.home.adapter.AdapterHomeLowker
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.home.adapter.AdapterHomeNews
import com.surelabs.auto.kartukuningmaluku.detaillowker.DetailLowker
import com.surelabs.auto.kartukuningmaluku.detailnews.DetailNewsActivity
import com.surelabs.auto.kartukuningmaluku.model.MCarousel
import com.surelabs.auto.kartukuningmaluku.model.MNews
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news.DataItem
import com.surelabs.auto.kartukuningmaluku.presenter.ICarouselPresenter
import com.surelabs.auto.kartukuningmaluku.presenter.INewsPresenter
import com.surelabs.auto.kartukuningmaluku.view.ICarouselView
import com.surelabs.auto.kartukuningmaluku.view.INewsView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.startActivity

class HomeFragment : Fragment(), INewsView, View.OnClickListener, ICarouselView {

    private var mINewsPresenter: INewsPresenter? = null
    private var mICarouselView: ICarouselPresenter? = null
    private var dataItem: DataItem? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getcarousel
        mICarouselView = MCarousel(this)
        mICarouselView?.getCarouselView()

        mINewsPresenter = MNews(activity, this)
        mINewsPresenter?.getLatestNews()
        mINewsPresenter?.getOneLatestNews()
        mINewsPresenter?.getLowker()


        //start shimmer
        shimmer_view_containerlowker.startShimmerAnimation()
        shimmer_view_containernews.startShimmerAnimation()

        //headline container
        headlineContainer.setOnClickListener(this)
        //lokasi listener
        lokasi.setOnClickListener(this)

        //berita listener
        berita.setOnClickListener(this)
    }

    override fun onNewsLoaded(itemNews: List<DataItem?>?) {
        shimmer_view_containernews.stopShimmerAnimation()
        val adapter = AdapterHomeNews(itemNews) { item ->
            startActivity<DetailNewsActivity>("data" to item)
        }
        rcBerita.adapter = adapter
    }

    override fun onNewsFailedLoad(message: String?, code: Int?) {
        context?.let { Toasty.error(it, "$message ($code)", Toast.LENGTH_SHORT, true).show() }
    }

    override fun onLowkerLoaded(itemLowker: List<com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.DataItem?>?) {
        shimmer_view_containerlowker.stopShimmerAnimation()
        shimmer_view_containerlowker.visibility = View.GONE
        val adapter = AdapterHomeLowker(itemLowker) { item ->
            startActivity<DetailLowker>("data" to item)
        }
        rcLowker.adapter = adapter
    }

    override fun onLowkerFailedLoad(message: String?, code: Int?) {
        context?.let { Toasty.error(it, "$message ($code)", Toast.LENGTH_SHORT, true).show() }
    }

    override fun onOneLatestNewsLoaded(itemNews: List<DataItem?>?) {
        shimmer_view_containernews.visibility = View.GONE
        itemNews?.forEach { item ->
            activity?.let { Glide.with(it).load(item?.fiturPhoto).into(headlineNews) }
            dataItem = item
            title.text = item?.judul
            tanggal.text = item?.addedOn
            isi.text = item?.isi
        }
    }

    override fun onOneLatestNewsFailedLoad(message: String?, code: Int?) {
        context?.let { Toasty.error(it, "$message ($code)", Toast.LENGTH_SHORT, true).show() }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.headlineContainer -> startActivity<DetailNewsActivity>("data" to dataItem)
            R.id.lokasi -> {
                val url = "https://goo.gl/maps/dBQLWwj8q9U5ykM86"
                val lokasi = Intent(Intent.ACTION_VIEW)
                lokasi.data = Uri.parse(url)
                startActivity(Intent.createChooser(lokasi, "Lanjutkan dengan..."))
            }
            R.id.berita -> {
                activity?.titles?.text = getString(R.string.berita)
                activity?.menu?.setItemSelected(R.id.berita)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, BeritaFragment())
                    ?.commit()
            }
        }
    }

    override fun onCarouselLoaded(itemCarouselView: List<com.surelabs.auto.kartukuningmaluku.network.datamodel.carousel.DataItem?>?) {
        carouselView.setImageListener { position, imageView ->
            context?.let {
                Glide.with(it).load(itemCarouselView?.get(position)?.path)
                    .apply(RequestOptions.placeholderOf(R.drawable.loader)).into(imageView)
            }
        }
        carouselView.pageCount = itemCarouselView?.size ?: 0

    }

    override fun onCarouselFailedLoad(message: String?, code: Int?) {
        context?.let { Toasty.warning(it, "$message ($code)", Toast.LENGTH_SHORT, true).show() }
    }

}
