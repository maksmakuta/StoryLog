package ua.makuta.storylog.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.makuta.storylog.model.ModelMenu
import ua.makuta.storylog.model.ModelVersion
import ua.makuta.storylog.net.storyNet
import ua.makuta.storylog.utils.Utils.logger

class MainViewModel : ViewModel() {

    val data = MutableLiveData<ModelMenu?>(null)
    val arrData = MutableLiveData<ArrayList<ModelVersion>?>(null)
    val item = MutableLiveData<ModelVersion?>(null)

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