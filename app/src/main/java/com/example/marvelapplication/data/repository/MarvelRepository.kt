package com.example.marvelapplication.data.repository

import com.example.marvelapplication.data.api.MarvelApi
import com.example.marvelapplication.domain.entity.CharacterEntity
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity
import com.example.marvelapplication.domain.mapper.CharacterMapper
import com.example.marvelapplication.domain.mapper.MarvelCharacterMapper
import com.example.marvelapplication.domain.repository.MarvelCharacterRepository
import org.koin.core.KoinComponent
import org.koin.core.inject


class MarvelRepository : MarvelCharacterRepository, KoinComponent {

    private val marvelApi: MarvelApi by inject()

    override fun getCharacter(characterId: Int): CharacterEntity {
        return CharacterMapper.convert(marvelApi.getCharacter(characterId).execute().body()!!)

    }

    override fun getMarvelCharacter(offset: Int): MarvelCharactersEntity {
        return MarvelCharacterMapper.convert(
            marvelApi.getMarvelCharacters(offset).execute().body()!!
        )
    }
}