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

        fun convertData(model: MarvelCharactersData.Data): MarvelCharactersEntity.Data =
            with(model) {
                MarvelCharactersEntity.Data(
                    count = count,
                    limit = limit,
                    offset = offset,
                    results = ResultsMapper.convert(results),
                    total = total
                )
            }
    }
}