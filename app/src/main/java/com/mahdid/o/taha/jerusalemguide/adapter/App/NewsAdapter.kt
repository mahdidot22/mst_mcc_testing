package com.mahdid.o.taha.jerusalemguide.adapter.App

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahdid.o.taha.jerusalemguide.DBHelper.DBHelper
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.model.news_model
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(val context: Context, val list: ArrayList<news_model>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    val dbHelper = DBHelper(context)

    class NewsViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val title = item.news_title
        val date = item.publishedAt
        val des = item.news_description
        val img = item.news_image
        val card = item.newsCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)

        return NewsViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.date.text = list[position].date
        holder.des.text = list[position].des
        holder.card.setOnClickListener {
            dbHelper.add_recent_news(list[position].title, list[position].img)
            notifyDataSetChanged()

            val url = list[position].url
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse(url)
            context.startActivity(intent)
        }

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
