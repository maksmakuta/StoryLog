package ua.makuta.storylog.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import ua.makuta.storylog.model.ModelApp
import ua.makuta.storylog.model.ModelMenu
import ua.makuta.storylog.model.ModelOS

interface RepoAPI {

    @GET("appdata/main.json")
    suspend fun getMenu(): ModelMenu

    @GET("appdata/{filename}")
    suspend fun getOsFile(@Path("filename") filename : String) : ArrayList<ModelOS>

    @GET("appdata/{filename}")
    suspend fun getAppFile(@Path("filename") filename : String) : ArrayList<ModelApp>

    @GET("appdata/{filename}")
    suspend fun getGameFile(@Path("filename") filename : String) : ArrayList<ModelApp>

}

private const val BASE_URL = "https://raw.githubusercontent.com/maksmakuta/StoryLog/dev/" //

val storyNet : RepoAPI = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(RepoAPI::class.java)
