package com.chernybro.wb81.data.remote

import com.chernybro.wb81.data.models.HeroStatsDTO

interface HeroListApi {

    suspend fun getHeroes(): List<HeroStatsDTO>?

    suspend fun getHero(id: Int) : HeroStatsDTO?

}