package ua.makuta.storylog

import android.app.Application
import android.content.Context
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder
import coil.disk.DiskCache
import okhttp3.Cache
import java.io.File

class StoryApp : Application(), ImageLoaderFactory {

    companion object{
        private lateinit var appContext : Context
        fun cache() = Cache(
            directory = File(appContext.cacheDir, "http_cache"),
            maxSize = 64L * 1024L * 1024L // 64 MiB
        )
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext
    }

    override fun newImageLoader() = ImageLoader.Builder(this)
        .diskCache(
            DiskCache.Builder()
                .directory(File(appContext.cacheDir, "coil_cache"))
                .maxSizeBytes(128L * 1024L * 1024L)
                .build()
        )
        .components {
            add(SvgDecoder.Factory())
        }
        .build()

}