package com.example.marvelapplication.domain.usecase

import com.example.marvelapplication.data.repository.MarvelRepository
import com.example.marvelapplication.domain.entity.CharacterEntity
import org.koin.core.KoinComponent
import org.koin.core.inject

class CharacterUseCase : KoinComponent {

    val repository: MarvelRepository by inject()

    fun getCharacter(characterID: Int): CharacterEntity {
        return repository.getCharacter(characterID)
    }
}