package com.mahdid.o.taha.jerusalemguide.fragments.App

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahdid.o.taha.jerusalemguide.DBHelper.DBHelper
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.adapter.App.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.view.*

class News : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        val dbHelper = DBHelper(requireContext())
        val adapter = NewsAdapter(requireContext(), dbHelper.get_news())
        root.news_list.setHasFixedSize(true)
        root.news_list.adapter = adapter
        root.news_list.layoutManager = LinearLayoutManager(requireContext())
        return root
    }
}
