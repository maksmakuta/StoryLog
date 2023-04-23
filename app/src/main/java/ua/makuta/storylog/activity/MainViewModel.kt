package ua.makuta.storylog.activity

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import ua.makuta.storylog.model.ModelMenu
import ua.makuta.storylog.model.ModelVersion
import ua.makuta.storylog.net.BASE_URL
import ua.makuta.storylog.net.storyNet
import ua.makuta.storylog.utils.Utils.logger
import java.io.IOException

class MainViewModel : ViewModel() {

    val data = MutableLiveData<ModelMenu?>(null)
    val arrData = MutableLiveData<ArrayList<ModelVersion>?>(null)
    val item = MutableLiveData<ModelVersion?>(null)
    val hasInternet = MutableLiveData<Boolean?>(null)

    fun checkNetwork(){
        val r = Request.Builder()
            .get()
            .url(BASE_URL + "settings.gradle")
            .build()
        OkHttpClient().newCall(r).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                hasInternet.postValue(false)
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                hasInternet.postValue(response.code == 200)
            }

        })
    }

    fun loadMenu(){
        viewModelScope.launch {
            val appData = storyNet.getMenu()
            data.postValue(appData)
            logger("data : $appData")
        }
    }

    fun loadFile(name : String){
        viewModelScope.launch {
            val tmp = storyNet.getFile(name)
            arrData.postValue(tmp)
            logger("data : $tmp")
        }
    }
}