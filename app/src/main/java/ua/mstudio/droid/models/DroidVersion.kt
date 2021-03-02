package ua.mstudio.droid.models

import java.io.Serializable

data class DroidVersion(val code : Int,val api : Int,val name : String,val version : String) : Serializable