package com.example.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.naturecollection.MainActivity
import com.example.naturecollection.PlantModel
import com.example.naturecollection.R

class PlantAdapter(private val context: MainActivity, private val plantList: List<PlantModel>, private val layoutId: Int) : RecyclerView.Adapter<PlantAdapter.ViewHolder>(){

    // Component box
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Plant image
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView? = view.findViewById(R.id.item_name)
        val plantDescription:TextView? = view.findViewById(R.id.item_description)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Récupération de la plante
        val currentPlant = plantList[position]
        // Use glide library
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)
        // Update plant infos
        holder.plantName?.text = currentPlant.name
        holder.plantDescription?.text = currentPlant.description
        if (currentPlant.liked) {
            holder.starIcon.setImageResource(R.drawable.ic_star_plain)
        } else {
            holder.starIcon.setImageResource(R.drawable.ic_star)
        }
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

}