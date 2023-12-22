package com.d121211059.tasks.domain

import com.d121211059.tasks.data.local.toDatabase
import com.d121211059.tasks.repo.GameRepository
import javax.inject.Inject


class GetGamesFromApiUseCase @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): List<GameItem>{

        val games = gameRepository.getGamesFromApi()

        return if (games.isNotEmpty()){
            gameRepository.deleteGames()
            gameRepository.insertGames(games.map { it.toDatabase() })
            games
        }else{
            emptyList()
        }
    }
}