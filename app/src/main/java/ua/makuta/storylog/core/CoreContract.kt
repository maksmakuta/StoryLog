package ua.makuta.storylog.core

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

interface CoreContract {

    interface IView{
        fun showLoader()
        fun hideLoader()
    }

    interface IPresenter{
        fun client() = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .callTimeout(10, TimeUnit.SECONDS)
            .build()
    }

}