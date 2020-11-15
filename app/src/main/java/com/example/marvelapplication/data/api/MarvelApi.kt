package com.example.marvelapplication.data.api

import com.example.marvelapplication.data.entity.CharacterData
import com.example.marvelapplication.data.entity.MarvelCharactersData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    companion object {
        const val LIST_CHARACTERS = "v1/public/characters"
        const val CHARACTER = "v1/public/characters/{characterID}"
    }

    @GET(LIST_CHARACTERS)
    fun getMarvelCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20,
        @Query("apikey") apikey: String = "f18e136b8bc4382c4e627967bd1b3065",
        @Query("ts") ts: Int = 1,
        @Query("hash") hash: String = "19cdb2e58947ef81b86549fc642f413b"
    ): Call<MarvelCharactersData>

    @GET(CHARACTER)
    fun getCharacter(
        @Path("characterID") characterID: Int,
        @Query("apikey") apikey: String = "f18e136b8bc4382c4e627967bd1b3065",
        @Query("ts") ts: Int = 1,
        @Query("hash") hash: String = "19cdb2e58947ef81b86549fc642f413b"
    ): Call<CharacterData>
}