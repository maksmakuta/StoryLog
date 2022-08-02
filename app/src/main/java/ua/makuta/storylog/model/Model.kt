package ua.makuta.storylog.model

import java.io.Serializable

data class Model(
    val api : Int,
    val version: String,
    val date : String,
    val logs : String,
    val codename : String
) : Serializable
