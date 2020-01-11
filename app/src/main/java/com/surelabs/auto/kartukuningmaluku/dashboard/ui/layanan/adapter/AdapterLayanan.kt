package com.surelabs.auto.kartukuningmaluku.dashboard.ui.layanan.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.kategorilayanan.DataItem
import kotlinx.android.synthetic.main.item_adapter_layanan.view.*

class AdapterLayanan(
    private val itemList: List<DataItem?>?,
    private val lambda: ((DataItem?) -> Unit)
) :
    RecyclerView.Adapter<AdapterLayanan.ViewHolder>() {

    class ViewHolder(
        itemView: View,
        var lambda: (DataItem?) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val itemList = itemView.list_item_view

        fun onBindItem(itemData: DataItem?) {
            itemList?.title = itemData?.namaKategori
            itemView.setOnClickListener {
                lambda(itemData)
            }
//            itemList?.inflateMenu(R.menu.layanan_detail_menu)
//            itemList?.setOnMenuItemClickListener {
//                when (it.itemId) {
//                    R.id.download -> {
//
//                    }
//                }
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_adapter_layanan,
                parent,
                false
            ),
            lambda
        )
    }

    override fun getItemCount(): Int = itemList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindItem(itemData = itemList?.get(position))
    }

}