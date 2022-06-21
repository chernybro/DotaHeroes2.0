package com.chernybro.wb81.data.local

import com.chernybro.wb81.data.models.HeroStatsDTO

interface HeroListStorage {

    fun saveHeroes(heroes: List<HeroStatsDTO>)

    fun getHeroes(): List<HeroStatsDTO>?

    fun getHero(id: Int): HeroStatsDTO?
}