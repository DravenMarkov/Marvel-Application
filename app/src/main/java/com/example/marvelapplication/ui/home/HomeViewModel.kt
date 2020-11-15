package com.example.marvelapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapplication.data.api.MarvelApi
import com.example.marvelapplication.data.entity.MarvelCharactersData
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity
import com.example.marvelapplication.domain.mapper.MarvelCharacterMapper
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel : ViewModel(), KoinComponent {

    private val marvelApi: MarvelApi by inject()

    private val liveMarvelCharacterList =
        MutableLiveData<List<MarvelCharactersEntity.Data.Result>>()

    private val characterList = mutableListOf<MarvelCharactersEntity.Data.Result>()

    private var offset = 0

    fun setListData(marvelCharactersEntity: MarvelCharactersEntity) {
        characterList.addAll(marvelCharactersEntity.data.results)
        liveMarvelCharacterList.value = characterList
    }

    fun getListCharacters() {
        // TODO SET AS A REPOSITORY
        //setListData(repository.getMarvelCharacter(offset).data.results)

        marvelApi.getMarvelCharacters(offset)
            .enqueue(object : Callback<MarvelCharactersData> {
                override fun onResponse(
                    call: Call<MarvelCharactersData>,
                    response: Response<MarvelCharactersData>
                ) {
                    setListData(response.body().let { MarvelCharacterMapper.convert(it!!) })
                }

                override fun onFailure(call: Call<MarvelCharactersData>, t: Throwable) {
                    t.localizedMessage
                }
            })
        offset += 20
    }

    fun getListCharactersLiveData(): LiveData<List<MarvelCharactersEntity.Data.Result>> {
        return liveMarvelCharacterList
    }
}