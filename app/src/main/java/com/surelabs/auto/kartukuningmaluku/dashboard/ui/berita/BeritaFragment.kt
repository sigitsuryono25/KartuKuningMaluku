package com.surelabs.auto.kartukuningmaluku.dashboard.ui.berita


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.home.adapter.AdapterHomeNews
import com.surelabs.auto.kartukuningmaluku.detailnews.DetailNewsActivity
import com.surelabs.auto.kartukuningmaluku.model.MNews
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news.DataItem
import com.surelabs.auto.kartukuningmaluku.presenter.INewsPresenter
import com.surelabs.auto.kartukuningmaluku.view.INewsView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_berita.*
import org.jetbrains.anko.support.v4.startActivity

class BeritaFragment : Fragment(), INewsView {
    private var mINewsPresenter: INewsPresenter? = null
    private val INIT_LIMIT = "10"
    private val INIT_START = "0"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mINewsPresenter = MNews(activity, this)
        mINewsPresenter?.getNewsPadding(INIT_START, INIT_LIMIT)

        //dropdown Kategori
        kategori.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }

        //dropdown Halaman

        halaman.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }
    }

    override fun onNewsLoaded(itemNews: List<DataItem?>?) {
        val adapter = AdapterHomeNews(itemNews) { item ->
            startActivity<DetailNewsActivity>("data" to item)
        }
        rcListBeritaPengumuman.adapter = adapter
    }

    override fun onNewsFailedLoad(message: String?, code: Int?) {
        context?.let { Toasty.warning(it, "$message ($code)", Toast.LENGTH_SHORT, true).show() }
    }

    override fun onLowkerLoaded(itemLowker: List<com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.DataItem?>?) {
    }

    override fun onLowkerFailedLoad(message: String?, code: Int?) {
    }

    override fun onOneLatestNewsLoaded(itemNews: List<DataItem?>?) {
    }

    override fun onOneLatestNewsFailedLoad(message: String?, code: Int?) {
    }


}
