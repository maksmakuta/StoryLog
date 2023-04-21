package ua.makuta.storylog.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.makuta.storylog.enums.DataType
import ua.makuta.storylog.model.ModelApp
import ua.makuta.storylog.model.ModelMenu
import ua.makuta.storylog.model.ModelOS
import ua.makuta.storylog.net.storyNet
import ua.makuta.storylog.utils.Utils.logger

class MainViewModel : ViewModel() {

    val data = MutableLiveData<ModelMenu?>(null)
    val osData = MutableLiveData<ArrayList<ModelOS>?>(null)
    val appData = MutableLiveData<ArrayList<ModelApp>?>(null)
    val gameData = MutableLiveData<ArrayList<ModelApp>?>(null)

    fun loadMenu(){
        viewModelScope.launch {
            val appData = storyNet.getMenu()
            data.postValue(appData)
            logger("data : $appData")
        }
    }

    fun loadFile(fname : String, type : Int){
        when(type){
            DataType.OS.ordinal -> {
                viewModelScope.launch {
                    val tmp = storyNet.getOsFile(fname)
                    osData.postValue(tmp)
                    logger("data : $tmp")
                }
            }
            DataType.APP.ordinal -> {
                viewModelScope.launch {
                    val tmp = storyNet.getAppFile(fname)
                    appData.postValue(tmp)
                    logger("data : $tmp")
                }
            }
            DataType.GAME.ordinal -> {
                viewModelScope.launch {
                    val tmp = storyNet.getGameFile(fname)
                    gameData.postValue(tmp)
                    logger("data : $tmp")
                }
            }
        }
    }
}