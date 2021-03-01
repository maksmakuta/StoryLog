package ua.mstudio.droid.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ua.mstudio.droid.models.DroidVersion

class NetUtils {

    private val baseUrl = "https://raw.githubusercontent.com/lakeFm/Droid/master"
    private val dataUrl = "$baseUrl/data/list.json"

    fun loadData() : ArrayList<DroidVersion>{
        val data = FileDM().read(dataUrl)
        val gson = Gson()
        val arrayTutorialType = object : TypeToken<ArrayList<DroidVersion>>() {}.type
        return gson.fromJson(data, arrayTutorialType)
    }

}