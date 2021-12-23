package com.mahdid.o.taha.jerusalemguide.fragments.App

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahdid.o.taha.jerusalemguide.DBHelper.DBHelper
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.adapter.App.Home.BreakingAdapter
import com.mahdid.o.taha.jerusalemguide.adapter.App.Home.RecentAdapter
import com.mahdid.o.taha.jerusalemguide.model.breaking_model
import kotlinx.android.synthetic.main.fragment_home.view.*

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val dbHelper = DBHelper(requireContext())
        val adapter = RecentAdapter(requireContext(), dbHelper.get_recent_news())
        root.recent_list.adapter = adapter
        root.recent_list.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val list2 = ArrayList<breaking_model>()
        for (i in 0 until 7) {
            if (i < dbHelper.get_news().size) {
                val title = dbHelper.get_news()[i].title
                val sub_title = dbHelper.get_news()[i].des
                val img = dbHelper.get_news()[i].img
                list2.add(breaking_model(title, sub_title, img))
            }
        }
        val adapter2 = BreakingAdapter(requireContext(), list2)
        root.brake_list.adapter = adapter2
        root.brake_list.layoutManager = LinearLayoutManager(requireContext())
        return root
    }
}
