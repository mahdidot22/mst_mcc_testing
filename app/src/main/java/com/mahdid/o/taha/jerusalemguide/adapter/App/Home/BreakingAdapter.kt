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
import com.mahdid.o.taha.jerusalemguide.model.breaking_model
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.brakenews_item.view.*

class BreakingAdapter(val context: Context, val list: ArrayList<breaking_model>) :
    RecyclerView.Adapter<BreakingAdapter.BreakingViewHolder>() {
    class BreakingViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val title = item.breaking_title
        val sub_title = item.breaking_subtitle
        val img = item.breaking_img
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingViewHolder {
        val inflater = LayoutInflater.from(context).inflate(R.layout.brakenews_item, parent, false)
        return BreakingViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: BreakingViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.sub_title.text = list[position].sub_title

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
