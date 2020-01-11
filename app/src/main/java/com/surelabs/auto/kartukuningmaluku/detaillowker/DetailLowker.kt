package com.surelabs.auto.kartukuningmaluku.detaillowker

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.model.MNews
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news.DataItem
import com.surelabs.auto.kartukuningmaluku.presenter.INewsPresenter
import com.surelabs.auto.kartukuningmaluku.view.INewsView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_detail_news.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailLowker : AppCompatActivity(), INewsView {

    private var mINewsPresenter: INewsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        setSupportActionBar(toolbar)
        titles.text = getString(R.string.detail_lowongan)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data =
            intent.getSerializableExtra("data") as com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.DataItem

        mINewsPresenter = MNews(this, this)
        mINewsPresenter?.getDetailLowker(data.idLowongan)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> NavUtils.navigateUpFromSameTask(this)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNewsLoaded(itemNews: List<DataItem?>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNewsFailedLoad(message: String?, code: Int?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLowkerLoaded(itemLowker: List<com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.DataItem?>?) {
        itemLowker?.forEach { item ->
            judul.text = item?.judul
            tanggal.text = item?.addedOn
            Glide.with(this).load(item?.fiturPhoto)
                .apply(RequestOptions.placeholderOf(R.drawable.loader)).into(fotogambar)
            isi.loadData(item?.isiLowongan, "text/html", "UTF-8")
            posisi.text = item?.posisi
        }
    }

    override fun onLowkerFailedLoad(message: String?, code: Int?) {
        this.let { Toasty.error(it, "$message ($code)", Toast.LENGTH_SHORT, true).show() }
    }

    override fun onOneLatestNewsLoaded(itemNews: List<DataItem?>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onOneLatestNewsFailedLoad(message: String?, code: Int?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
