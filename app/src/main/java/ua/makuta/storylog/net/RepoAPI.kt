package ua.makuta.storylog.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import ua.makuta.storylog.model.ModelVersion
import ua.makuta.storylog.model.ModelMenu

interface RepoAPI {

    @GET("appdata/main.json")
    suspend fun getMenu(): ModelMenu

    @GET("{filename}")
    suspend fun getFile(@Path("filename") filename : String) : ArrayList<ModelVersion>

}

const val BASE_URL = "https://raw.githubusercontent.com/maksmakuta/StoryLog/dev/"

val storyNet : RepoAPI = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(RepoAPI::class.java)
