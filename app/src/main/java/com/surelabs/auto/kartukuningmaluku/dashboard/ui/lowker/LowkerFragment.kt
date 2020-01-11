package com.surelabs.auto.kartukuningmaluku.dashboard.ui.lowker


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.lowker.adapter.AdapterLowker
import com.surelabs.auto.kartukuningmaluku.detaillowker.DetailLowker
import com.surelabs.auto.kartukuningmaluku.model.MLowker
import com.surelabs.auto.kartukuningmaluku.presenter.ILowkerPresenter
import com.surelabs.auto.kartukuningmaluku.view.ILowkerView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_lowker.*
import org.jetbrains.anko.support.v4.startActivity

class LowkerFragment : Fragment(), ILowkerView {
    private var mILowkerPresenter: ILowkerPresenter? = null
    private val INIT_LIMIT = "10"
    private val INIT_START = "0"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lowker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mILowkerPresenter = MLowker(this)
        mILowkerPresenter?.getLowkerPadding(INIT_START, INIT_LIMIT)

    }

    override fun onLowkerLoaded(itemLowker: List<com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.DataItem?>?) {
        val adapter = AdapterLowker(itemLowker) { item ->
            startActivity<DetailLowker>("data" to item)
        }

        rcListBeritaPengumuman.adapter = adapter

    }

    override fun onLowkerFailedLoad(message: String?, code: Int?) {
        context?.let { Toasty.warning(it, "$message ($code)", Toast.LENGTH_SHORT, true).show() }
    }


}
