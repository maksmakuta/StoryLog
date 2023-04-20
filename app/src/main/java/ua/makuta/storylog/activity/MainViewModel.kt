package ua.makuta.storylog.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.makuta.storylog.model.ModelMenu
import ua.makuta.storylog.net.storyNet
import ua.makuta.storylog.utils.Utils.logger

class MainViewModel : ViewModel() {

    val data = MutableLiveData<ModelMenu?>(null)

    fun loadMenu(){
        viewModelScope.launch {
            val appData = storyNet.getMenu()
            data.postValue(appData)
            logger("data : $appData")
        }
    }

}