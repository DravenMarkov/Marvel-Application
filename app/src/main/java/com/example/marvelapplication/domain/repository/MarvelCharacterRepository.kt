package com.example.marvelapplication.domain.repository

import com.example.marvelapplication.domain.entity.CharacterEntity
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity

interface MarvelCharacterRepository {

    fun getCharacter(characterId: Int): CharacterEntity

    fun getMarvelCharacter(offset: Int): MarvelCharactersEntity
}