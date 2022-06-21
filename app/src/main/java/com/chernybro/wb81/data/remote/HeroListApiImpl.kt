package com.chernybro.wb81.data.remote

import com.chernybro.wb81.data.models.HeroStatsDTO
import com.chernybro.wb81.utils.Constants
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import okhttp3.OkHttpClient
import okhttp3.Request

@OptIn(ExperimentalStdlibApi::class)
class HeroListApiImpl(
    private val okHttpClient: OkHttpClient, private val moshi: Moshi
) : HeroListApi {

    override suspend fun getHeroes(): List<HeroStatsDTO>? {
        val request: Request = Request.Builder()
            .url(Constants.HEROES_BASE_URL + Constants.HEROES_STATS_ENDPOINT)
            .build()

        val response = okHttpClient.newCall(request).execute()
        val json: String = response.body?.string() ?: ""

        val jsonAdapter: JsonAdapter<List<HeroStatsDTO>> = moshi.adapter()

        return jsonAdapter.fromJson(json)

    }

    override suspend fun getHero(id: Int): HeroStatsDTO? {
        val request: Request = Request.Builder()
            .url(Constants.HEROES_BASE_URL + Constants.HEROES_STATS_ENDPOINT)
            .build()

        val response = okHttpClient.newCall(request).execute()
        val json: String = response.body?.string() ?: ""

        val jsonAdapter: JsonAdapter<List<HeroStatsDTO>> = moshi.adapter()

        val heroesDTO = jsonAdapter.fromJson(json)

        return heroesDTO?.first { heroStatsDTO -> heroStatsDTO.id == id }
    }

}