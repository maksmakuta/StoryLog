package ua.makuta.storylog.model

data class ModelVersion(
    var args : Map<String,String> = mapOf(),
    val version : String,
    val date : String,
    val logs : String
)
