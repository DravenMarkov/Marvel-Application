package com.example.marvelapplication.domain.usecase

import com.example.marvelapplication.data.repository.MarvelRepository
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetCharactersListUseCase : KoinComponent {

    val repository: MarvelRepository by inject()

    fun getCharacter(offset: Int): MarvelCharactersEntity {
        return repository.getMarvelCharacter(offset)
    }
}