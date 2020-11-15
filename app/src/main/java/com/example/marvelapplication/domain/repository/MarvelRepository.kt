package com.example.marvelapplication.domain.repository

import com.example.marvelapplication.data.api.MarvelApi
import com.example.marvelapplication.data.entity.MarvelCharactersData
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity
import com.example.marvelapplication.domain.mapper.MarvelCharacterMapper
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MarvelRepository : KoinComponent {

    val marvelApi: MarvelApi by inject()

    fun getMarvelCharacter(offset: Int): MarvelCharactersEntity {
        val dat = MarvelCharactersEntity.Data(count = 1, limit = 1, offset = 1, results = listOf(), total = 1)
        var data = MarvelCharactersEntity(data = dat)
        //LiveData<MarvelCharactersEntity>(
        //data = MarvelCharactersEntity.Data(0, 0, 0, results = listOf(), total = 0) )
        marvelApi.getMarvelCharacters(offset)
            .enqueue(object : Callback<MarvelCharactersData> {
                override fun onResponse(
                    call: Call<MarvelCharactersData>,
                    response: Response<MarvelCharactersData>
                ) {
                    data = MarvelCharacterMapper.convert(response.body()!!)
                }

                override fun onFailure(call: Call<MarvelCharactersData>, t: Throwable) {
                    t.localizedMessage
                }
            })
        return data
    }
}