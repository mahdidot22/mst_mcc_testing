package com.mahdid.o.taha.jerusalemguide.adapter.App.History

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener
import com.google.android.youtube.player.YouTubeThumbnailView
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.model.video_model
import kotlinx.android.synthetic.main.video_item.*
import kotlinx.android.synthetic.main.video_item.view.*

class VideosAdapter(val list: List<video_model>, val context: Context) :
    RecyclerView.Adapter<VideosAdapter.videoViewHolder>() {
    class videoViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val video = item.youtube_thumbnail
        val playButton: ImageView = item.btnYoutube_player
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): videoViewHolder {
        val Inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return videoViewHolder(Inflater)
    }

    override fun onBindViewHolder(holder: videoViewHolder, position: Int) {
        val api_key = "AIzaSyBgqqJeEt5i8OIKDc59fb20WOdR0c2tuHk"

        val onThumbnailLoadedListener: OnThumbnailLoadedListener =
            object : OnThumbnailLoadedListener {
                override fun onThumbnailError(
                    youTubeThumbnailView: YouTubeThumbnailView,
                    errorReason: YouTubeThumbnailLoader.ErrorReason
                ) {
                }

                override fun onThumbnailLoaded(
                    youTubeThumbnailView: YouTubeThumbnailView,
                    s: String
                ) {
                    youTubeThumbnailView.visibility = View.VISIBLE
                    holder.video.visibility = View.VISIBLE
                }
            }

        holder.video.initialize(
            api_key,
            object : YouTubeThumbnailView.OnInitializedListener {
                override fun onInitializationSuccess(
                    youTubeThumbnailView: YouTubeThumbnailView,
                    youTubeThumbnailLoader: YouTubeThumbnailLoader
                ) {
                    youTubeThumbnailLoader.setVideo(list[position].video)
                    youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener)
                }

                override fun onInitializationFailure(
                    youTubeThumbnailView: YouTubeThumbnailView,
                    youTubeInitializationResult: YouTubeInitializationResult
                ) {
                }
            })

        holder.playButton.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(
                context as Activity?,
                api_key,
                list[position].video
            )
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
