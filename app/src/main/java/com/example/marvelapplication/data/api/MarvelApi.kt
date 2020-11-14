package com.example.marvelapplication.data.api

import retrofit2.http.GET

interface MarvelApi {

    companion object {

    }

    @GET("marvel_characters")
    fun getMarvelCharacters()

    @GET("")
    fun getCharacter()
}