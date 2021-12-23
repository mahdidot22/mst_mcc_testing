package com.mahdid.o.taha.jerusalemguide.fragments.App

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.fragments.App.HistoryFragments.Images
import com.mahdid.o.taha.jerusalemguide.fragments.App.HistoryFragments.Videos
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_history.view.*

class History : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_history, container, false)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, Videos()).commit()
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
