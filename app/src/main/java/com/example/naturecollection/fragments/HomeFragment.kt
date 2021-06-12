package com.example.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.naturecollection.MainActivity
import com.example.naturecollection.PlantModel
import com.example.naturecollection.R
import com.example.naturecollection.adapter.PlantAdapter
import com.example.naturecollection.adapter.PlantItemDecoration

class HomeFragment(private val context: MainActivity) : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        // Static list of plants
        val plantList = arrayListOf<PlantModel>()

        // Add a new plant
        plantList.add(
            PlantModel(
                "Pissenlit",
                "Jaune soleil",
                "https://cdn.pixabay.com/photo/2014/05/01/17/51/flower-335662_960_720.jpg",
                true
            )
        )
        plantList.add(
            PlantModel(
                "Rose",
                "Ça pique un peu...",
                "https://cdn.pixabay.com/photo/2018/05/16/22/27/rose-3407234_960_720.jpg",
                false
            )
        )
        plantList.add(
            PlantModel(
                "Cactus",
                "Aïe !",
                "https://cdn.pixabay.com/photo/2016/07/06/20/47/prickly-pear-1501307_960_720.jpg",
                true
            )
        )
        plantList.add(
            PlantModel(
                "Tulipe",
                "C\'est beau",
                "https://cdn.pixabay.com/photo/2017/03/13/21/19/tulip-2141216_960_720.jpg",
                false
            )
        )

        // Récupération du RecyclerView
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_horizontal_plant)

        // Récupération du 2eme RecyclerView
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }
}