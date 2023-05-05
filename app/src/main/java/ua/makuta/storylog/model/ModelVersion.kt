package ua.makuta.storylog.model

import ua.makuta.storylog.utils.Utils.VER_HEADER

data class ModelVersion(
    var args : Map<String,String> = mapOf(),
    val version : String,
    val date : String,
    val logs : String
){
    fun isHeader() : Boolean{
        return if(args.containsKey(VER_HEADER)){
            args[VER_HEADER] == "true"
        }else{
            false
        }
    }
}
