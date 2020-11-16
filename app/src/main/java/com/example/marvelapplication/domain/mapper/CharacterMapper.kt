package com.example.marvelapplication.domain.mapper

import com.example.marvelapplication.data.entity.CharacterData
import com.example.marvelapplication.domain.entity.CharacterEntity

class CharacterMapper {
    companion object {


        fun convert(model: CharacterData): CharacterEntity = with(model) {
            CharacterEntity(
                data = convertData(data)
            )
        }

        private fun convertData(model: CharacterData.Data): CharacterEntity.Data = with(model) {
            CharacterEntity.Data(
                results = convertResults(results)
            )
        }

        private fun convertResults(listResult: List<CharacterData.Data.Result>): List<CharacterEntity.Data.Result> =
            listResult.map { convertResult(it) }

        private fun convertResult(model: CharacterData.Data.Result): CharacterEntity.Data.Result =
            with(model) {
                CharacterEntity.Data.Result(
                    id = id,
                    name = name,
                    resourceURI = resourceURI,
                    thumbnail = thumbnail.path + "." + thumbnail.extension,
                    description = description
                )
            }
    }
}
