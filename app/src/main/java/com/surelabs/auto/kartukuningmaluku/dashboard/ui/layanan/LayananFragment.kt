package com.surelabs.auto.kartukuningmaluku.dashboard.ui.layanan


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.layanan.adapter.AdapterLayanan
import com.surelabs.auto.kartukuningmaluku.detaillayanan.DetailLayananActivity
import com.surelabs.auto.kartukuningmaluku.model.MLayanan
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.kategorilayanan.DataItem
import com.surelabs.auto.kartukuningmaluku.presenter.ILayananPresenter
import com.surelabs.auto.kartukuningmaluku.view.ILayananView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_layanan.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class LayananFragment : Fragment(), ILayananView {

    private var iLayananPresenter: ILayananPresenter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layanan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iLayananPresenter = MLayanan(this)
        iLayananPresenter?.getListKategoriLayanan()
    }

    override fun onLayananLoaded(itemLayanan: List<DataItem?>?) {
        val adapter = AdapterLayanan(itemLayanan) { item ->
            startActivity<DetailLayananActivity>("data" to item)
        }
        rcLayanan.adapter = adapter
    }

    override fun onLayananFailedLoad(message: String?, code: Int?) {
        activity?.let { Toasty.error(it, "$message ($code)", Toasty.LENGTH_SHORT).show() }
    }

    override fun onDetailLayananLoaded(itemDetail: List<com.surelabs.auto.kartukuningmaluku.network.datamodel.detail.layanan.DataItem?>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
