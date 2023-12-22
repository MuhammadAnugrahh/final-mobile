package com.d121211059.tasks.repo

import com.d121211059.tasks.data.local.GameDao
import com.d121211059.tasks.data.local.GameEntity
import com.d121211059.tasks.data.remote.GameService
import com.d121211059.tasks.domain.GameItem
import com.d121211059.tasks.domain.toDomain
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val gameService: GameService,
    private val gameDao: GameDao) {

    suspend fun getGamesFromApi(): List<GameItem>{
        val games = gameService.getGames()
        return games.map { it.toDomain() }
    }

    suspend fun getGameFromDatabase(): List<GameItem>{
        val games = gameDao.getGames()
        return games.map { it.toDomain() }
    }

    suspend fun insertGames(games:List<GameEntity>){
        gameDao.insertGames(games)
    }

    suspend fun deleteGames(){
        gameDao.deleteGames()
    }

}