package com.mahdid.o.taha.jerusalemguide.fragments.App.HistoryFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.adapter.App.History.VideosAdapter
import com.mahdid.o.taha.jerusalemguide.model.video_model
import kotlinx.android.synthetic.main.fragment_videos.view.*

class Videos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_videos, container, false)
        val list = ArrayList<video_model>()
        list.add(video_model("LV127KguHS8"))
        list.add(video_model("DocVV8fpBXg"))
        list.add(video_model("WI_2ge52Jx4"))
        list.add(video_model("YZI5-ovzcQg"))
        list.add(video_model("rn8L2bDqJZY"))
        list.add(video_model("ZPOrVb9_qJU"))
        list.add(video_model("-QBDlf3gQ28"))
        list.add(video_model("oHxcXOnD2tY"))
        list.add(video_model("vGLlOpXcpGY"))
        list.add(video_model("KT9rOnEotB0"))
        val adapter = VideosAdapter(list, requireContext())
        root.videos_list.layoutManager = LinearLayoutManager(requireContext())
        root.videos_list.adapter = adapter

        root.images_btn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, Images()).commit()
        }
        root.videos_btn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, Videos()).commit()
        }

        return root
    }
}
