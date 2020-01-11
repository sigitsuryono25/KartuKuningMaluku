package com.surelabs.auto.kartukuningmaluku.detaillayanan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.network.datamodel.detail.layanan.DataItem
import kotlinx.android.synthetic.main.item_adapter_layanan.view.*

class AdapterDetailLayanan(
    private val itemList: List<DataItem?>?,
    private val lambda: ((DataItem?) -> Unit)
) :
    RecyclerView.Adapter<AdapterDetailLayanan.ViewHolder>() {

    class ViewHolder(
        itemView: View,
        var lambda: (DataItem?) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val itemList = itemView.list_item_view

        fun onBindItem(itemData: DataItem?) {
            itemList?.title = itemData?.judul
            itemList?.inflateMenu(R.menu.layanan_detail_menu)
            itemList?.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.download -> {
                        lambda(itemData)
                    }
                }
            }
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