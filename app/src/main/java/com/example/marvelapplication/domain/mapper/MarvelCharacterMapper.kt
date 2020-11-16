package com.example.marvelapplication.domain.mapper

import com.example.marvelapplication.data.entity.MarvelCharactersData
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity

class MarvelCharacterMapper {

    companion object {
        fun convert(model: MarvelCharactersData): MarvelCharactersEntity = with(model) {
            MarvelCharactersEntity(
                data = convertData(data)
            )
        }

        private fun convertData(model: MarvelCharactersData.Data): MarvelCharactersEntity.Data =
            with(model) {
                MarvelCharactersEntity.Data(
                    count = count,
                    limit = limit,
                    offset = offset,
                    results = convertResults(results),
                    total = total
                )
            }

        private fun convertResults(listResult: List<MarvelCharactersData.Data.Result>): List<MarvelCharactersEntity.Data.Result> =
            listResult.map { convertResult(it) }

        private fun convertResult(model: MarvelCharactersData.Data.Result): MarvelCharactersEntity.Data.Result =
            with(model) {
                MarvelCharactersEntity.Data.Result(
                    id = id,
                    name = name,
                    resourceURI = resourceURI,
                    thumbnail = convertThumbnail(thumbnail)
                )
            }

        private fun convertThumbnail(model: MarvelCharactersData.Data.Result.Thumbnail): MarvelCharactersEntity.Data.Result.Thumbnail =
            with(model) {
                MarvelCharactersEntity.Data.Result.Thumbnail(
                    extension = extension,
                    path = path
                )
            }
    }
}