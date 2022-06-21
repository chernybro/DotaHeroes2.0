package com.chernybro.wb81.data.repository

import com.chernybro.wb81.domain.models.HeroDetailsItem
import com.chernybro.wb81.domain.models.HeroItem
import com.chernybro.wb81.presentation.models.ScreenState

interface HeroesRepository {

    suspend fun getHeroes(): ScreenState<List<HeroItem>>

    suspend fun getHero(id: Int): ScreenState<HeroDetailsItem>
}