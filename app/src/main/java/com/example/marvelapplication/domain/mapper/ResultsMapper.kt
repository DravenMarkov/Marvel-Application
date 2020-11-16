package com.example.marvelapplication.domain.mapper

import com.example.marvelapplication.data.entity.MarvelCharactersData
import com.example.marvelapplication.domain.entity.MarvelCharactersEntity

class ResultsMapper {

    companion object {
        fun convert(listResult: List<MarvelCharactersData.Data.Result>): List<MarvelCharactersEntity.Data.Result> =
            listResult.map { convert(it) }

        private fun convert(model: MarvelCharactersData.Data.Result): MarvelCharactersEntity.Data.Result =
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