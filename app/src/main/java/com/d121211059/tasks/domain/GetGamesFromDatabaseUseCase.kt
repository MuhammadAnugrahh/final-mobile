package com.d121211059.tasks.domain

import com.d121211059.tasks.repo.GameRepository
import javax.inject.Inject

class GetGamesFromDatabaseUseCase @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(): List<GameItem>{
        val games = gameRepository.getGameFromDatabase()

        return games.ifEmpty {
            emptyList()
        }
    }
}