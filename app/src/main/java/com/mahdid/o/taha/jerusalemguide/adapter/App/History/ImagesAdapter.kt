package com.mahdid.o.taha.jerusalemguide.adapter.App.History

import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.model.image_model
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.images_item.view.*

class ImagesAdapter(val context: Context, val list: ArrayList<image_model>) :
    RecyclerView.Adapter<ImagesAdapter.imageViewHolder>() {
    class imageViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val img = item.image_item_images
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): imageViewHolder {
        val Inflater = LayoutInflater.from(context).inflate(R.layout.images_item, parent, false)
        return imageViewHolder(Inflater)
    }

    override fun onBindViewHolder(holder: imageViewHolder, position: Int) {
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
