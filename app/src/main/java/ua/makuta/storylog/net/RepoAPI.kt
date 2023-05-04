package ua.makuta.storylog.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import ua.makuta.storylog.StoryApp
import ua.makuta.storylog.model.ModelMenu
import ua.makuta.storylog.model.ModelVersion

interface RepoAPI {

    @GET("appdata/main.json")
    suspend fun getMenu(): ModelMenu

    @GET("{filename}")
    suspend fun getFile(@Path("filename") filename : String) : ArrayList<ModelVersion>

}

const val BASE_URL = "https://raw.githubusercontent.com/maksmakuta/StoryLog/app/"

private val client: OkHttpClient = OkHttpClient.Builder()
    .cache(StoryApp.cache())
    .build()

val storyNet : RepoAPI = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(RepoAPI::class.java)
