package com.example.marvelapplication.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapplication.data.database.CharacterDataBase
import com.example.marvelapplication.domain.entity.CharacterEntity
import com.example.marvelapplication.domain.usecase.CharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailViewModel : ViewModel(), KoinComponent {

    private val characterLiveData = MutableLiveData<CharacterEntity.Data.Result>()
    private val useCase: CharacterUseCase by inject()
    private val characterDataBase: CharacterDataBase by inject()

    private fun saveCharacterIntoDb(character: CharacterEntity.Data.Result) {
        characterDataBase.characterDao().insert(character)
    }

    fun getCharacterFromDB(characterId: Int) {
        if (characterDataBase.characterDao().isExist(characterId)) {
            characterLiveData.value =
                characterDataBase.characterDao().findCharacterById(characterId)
        } else {
            getCharacter(characterId)
        }
    }

    private fun setCharacterData(character: CharacterEntity) {
        this.characterLiveData.value = character.data.results[0]
        saveCharacterIntoDb(character.data.results[0])
    }

    private fun getCharacter(characterId: Int) {

        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { useCase.getCharacter(characterId) }
            setCharacterData(result)
        }
    }

    fun getCharacterLiveData(): LiveData<CharacterEntity.Data.Result> {
        return characterLiveData
    }
}