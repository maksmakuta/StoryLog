package ua.makuta.storylog

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder

class StoryApp : Application(), ImageLoaderFactory {

    override fun onCreate() {
        super.onCreate()
    }

    override fun newImageLoader() = ImageLoader.Builder(this)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()

}