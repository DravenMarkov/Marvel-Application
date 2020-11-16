package com.example.marvelapplication.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity
import com.example.marvelapplication.domain.usecase.GetCharactersListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject


class HomeViewModel : ViewModel(), KoinComponent {

    private val useCase: GetCharactersListUseCase by inject()

    private val marvelCharactersLiveData =
        MutableLiveData<List<MarvelCharactersEntity.Data.Result>>()

    private val characterList = mutableListOf<MarvelCharactersEntity.Data.Result>()

    private var offset = 0

    private fun setListData(marvelCharactersEntity: MarvelCharactersEntity) {
        characterList.addAll(marvelCharactersEntity.data.results)
        marvelCharactersLiveData.value = characterList
    }

    fun getListCharacters() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                useCase.getCharacter(offset)
            }
            setListData(result)
            offset += 20
        }
    }

    fun getListCharactersLiveData(): LiveData<List<MarvelCharactersEntity.Data.Result>> {
        return marvelCharactersLiveData
    }
}