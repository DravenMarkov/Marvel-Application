package com.example.marvelapplication.domain.usecase

import com.example.marvelapplication.domain.entity.MarvelCharactersEntity
import com.example.marvelapplication.domain.repository.MarvelRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetCharactersListUseCase : KoinComponent {

    val repository: MarvelRepository by inject()

    fun getCharacter(offset: Int): MarvelCharactersEntity {
        val response = repository.getMarvelCharacter(offset)

        return response
    }
}