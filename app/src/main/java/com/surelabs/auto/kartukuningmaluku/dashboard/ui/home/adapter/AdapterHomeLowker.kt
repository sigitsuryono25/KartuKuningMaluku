package com.surelabs.auto.kartukuningmaluku.dashboard.ui.home.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker.DataItem
import kotlinx.android.synthetic.main.item_adapter_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class AdapterHomeLowker(
    private val item: List<DataItem?>?,
    private val lambda: ((DataItem?) -> Unit)
) :
    RecyclerView.Adapter<AdapterHomeLowker.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            parent.context,
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_adapter_home,
                parent,
                false
            ),
            lambda
        )
    }

    override fun getItemCount(): Int = item?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onItemBind(item?.get(position))
    }

    class ViewHolder(
        val context: Context,
        itemView: View,
        val lambda: (DataItem?) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        var imageview = itemView.imageItem
        var title = itemView.itemTitle
        fun onItemBind(item: DataItem?) {
            Glide.with(context).load(item?.fiturPhoto).into(imageview)
            title.text = item?.judul
            itemView.setOnClickListener {
                lambda(item)
            }
        }
    }

}