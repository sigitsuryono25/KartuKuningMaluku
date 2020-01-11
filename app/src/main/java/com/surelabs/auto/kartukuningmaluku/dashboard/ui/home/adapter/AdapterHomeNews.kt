package com.surelabs.auto.kartukuningmaluku.dashboard.ui.home.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news.DataItem
import kotlinx.android.synthetic.main.item_adapter_home.view.imageItem
import kotlinx.android.synthetic.main.item_adapter_home.view.itemTitle
import kotlinx.android.synthetic.main.item_list_.view.*

/**
 * A simple [Fragment] subclass.
 */
class AdapterHomeNews(
    private val item: List<DataItem?>?,
    private val lambda: ((DataItem?) -> Unit)
) :
    RecyclerView.Adapter<AdapterHomeNews.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            parent.context,
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_,
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
        val tanggal = itemView.tanggal
        var title = itemView.itemTitle
        fun onItemBind(item: DataItem?) {
            Glide.with(context).load(item?.fiturPhoto)
                .apply(RequestOptions.placeholderOf(R.drawable.loader)).into(imageview)
            title.text = item?.judul
            tanggal.text = item?.addedOn
            itemView.setOnClickListener {
                lambda(item)
            }
        }
    }

}