package com.example.marvelapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapplication.data.api.MarvelApi
import com.example.marvelapplication.data.entity.CharacterData
import com.example.marvelapplication.domain.entity.CharacterEntity
import com.example.marvelapplication.domain.mapper.CharacterMapper
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel(), KoinComponent {

    private val character = MutableLiveData<List<CharacterEntity.Data.Result>>()
    val marvelApi: MarvelApi by inject()

    fun setCharacterData(character: CharacterEntity) {
        this.character.value = character.data.results
    }

    fun getCharacter(characterId: Int) {
        marvelApi.getCharacter(characterId).enqueue(object : Callback<CharacterData> {
            override fun onResponse(call: Call<CharacterData>, response: Response<CharacterData>) {
                setCharacterData(response.body().let { CharacterMapper.convert(it!!) })
            }

            override fun onFailure(call: Call<CharacterData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    fun getCharacterLiveData(): LiveData<List<CharacterEntity.Data.Result>> {
        return character
    }
}