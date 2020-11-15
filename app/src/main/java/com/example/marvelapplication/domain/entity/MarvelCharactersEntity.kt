package com.example.marvelapplication.domain.entity

data class MarvelCharactersEntity(
    val data: Data
) {
    data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: List<Result>,
        val total: Int
    ) {
        data class Result(
            val id: Int,
            val name: String,
            val resourceURI: String,
            val thumbnail: Thumbnail
        ) {

            data class Thumbnail(
                val extension: String,
                val path: String
            )
        }
    }

}