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

        fun convertData(model: CharacterData.Data): CharacterEntity.Data = with(model) {
            CharacterEntity.Data(
                results = convertResulst(results)
            )
        }

        fun convertResulst(listResult: List<CharacterData.Data.Result>): List<CharacterEntity.Data.Result> =
            listResult.map { convertResult(it) }

        fun convertResult(model: CharacterData.Data.Result): CharacterEntity.Data.Result =
            with(model) {
                CharacterEntity.Data.Result(
                    id = id,
                    name = name,
                    resourceURI = resourceURI,
                    thumbnail = convertThumbnail(thumbnail),
                    description = description
                )
            }

        fun convertThumbnail(model: CharacterData.Data.Result.Thumbnail): CharacterEntity.Data.Result.Thumbnail =
            with(model) {
                CharacterEntity.Data.Result.Thumbnail(
                    extension = extension,
                    path = path
                )
            }
    }
}
