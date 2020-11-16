package com.example.marvelapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapplication.domain.entity.CharacterEntity
import com.example.marvelapplication.domain.usecase.CharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailViewModel : ViewModel(), KoinComponent {

    private val character = MutableLiveData<List<CharacterEntity.Data.Result>>()
    private val useCase: CharacterUseCase by inject()

    private fun setCharacterData(character: CharacterEntity) {
        this.character.value = character.data.results
    }

    fun getCharacter(characterId: Int) {

        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { useCase.getCharacter(characterId) }
            setCharacterData(result)
        }
    }

    fun getCharacterLiveData(): LiveData<List<CharacterEntity.Data.Result>> {
        return character
    }
}