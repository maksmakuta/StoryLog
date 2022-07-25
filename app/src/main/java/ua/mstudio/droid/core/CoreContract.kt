package ua.mstudio.droid.core

import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

interface CoreContract {

    interface IView{

    }

    interface IPresenter{
        fun getOkhttp() : OkHttpClient {
            val dispatcher = Dispatcher()
            dispatcher.maxRequests = 1
            val okHttpClientBuilder = OkHttpClient.Builder()
            okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
            okHttpClientBuilder.writeTimeout(60, TimeUnit.SECONDS)
            return okHttpClientBuilder.dispatcher(dispatcher).build()
        }
    }

}