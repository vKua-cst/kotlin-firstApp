package com.example.naturecollection

import org.w3c.dom.Text

class PlantModel(
    val name: String = "Tulipe",
    val description: String = "Petite description",
    val imageUrl: String = "http://graven.yt/plante.jpg",
    var liked: Boolean = false
)