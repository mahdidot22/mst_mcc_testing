package com.mahdid.o.taha.jerusalemguide.fragments.App.HistoryFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.adapter.App.History.ImagesAdapter
import com.mahdid.o.taha.jerusalemguide.model.image_model
import kotlinx.android.synthetic.main.fragment_history.view.*
import kotlinx.android.synthetic.main.fragment_images.view.*
import kotlinx.android.synthetic.main.fragment_images.view.images_btn
import kotlinx.android.synthetic.main.fragment_images.view.videos_btn

class Images : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val storage = Firebase.storage
        val root = inflater.inflate(R.layout.fragment_images, container, false)
        val storageRef = storage.reference.child("Images")
        val list = ArrayList<image_model>()
        val listAllTask = storageRef.listAll()
        listAllTask.addOnCompleteListener { result ->
            val items = result.result!!.items
            items.forEachIndexed { _, item ->
                item.downloadUrl.addOnSuccessListener {
                    list.add(image_model(it.toString()))
                }.addOnCompleteListener {
                    val adapter = ImagesAdapter(requireContext(), list)
                    root.images_list.layoutManager = LinearLayoutManager(requireContext())
                    root.images_list.adapter = adapter
                }
            }
        }
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
