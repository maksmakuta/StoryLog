package ua.mstudio.droid.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ua.mstudio.droid.models.DroidStory
import ua.mstudio.droid.models.DroidVersion

class GsonUtils {

    fun loadData(ctx : Context) : ArrayList<DroidVersion>{
        val data = FileUtils().mainData(ctx)
        //print(data)
        val arrayTutorialType = object : TypeToken<ArrayList<DroidVersion>>() {}.type
        return Gson().fromJson(data, arrayTutorialType)
    }

    fun loadStory(ctx : Context,obj : DroidVersion) : DroidStory{
        val data = FileUtils().loadStory(obj.code,ctx)
        //print(data)
        return Gson().fromJson(data, DroidStory::class.java)

    }

}