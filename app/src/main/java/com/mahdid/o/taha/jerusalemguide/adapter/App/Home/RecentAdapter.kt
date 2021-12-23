package com.mahdid.o.taha.jerusalemguide.adapter.App.Home

import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.model.recent_model
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recent_item.view.*

class RecentAdapter(val context: Context, val list: ArrayList<recent_model>) : RecyclerView.Adapter<RecentAdapter.RecentViewHolder>() {
    class RecentViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val img = item.image_item
        val title = item.text_item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        val inflater = LayoutInflater.from(context).inflate(R.layout.recent_item, parent, false)

        return RecentViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        holder.title.text = list[position].titel
        val uiHandler = Handler(Looper.getMainLooper())
        uiHandler.post {
            Picasso.with(context)
                .load(Uri.parse(list[position].img))
                .into(holder.img)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
