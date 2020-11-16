package com.example.marvelapplication.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CharacterEntity(
    val data: Data
) {
    data class Data(
        val results: List<Result>
    ) {
        @Entity(tableName = "characters")
        data class Result(
            val description: String,
            @PrimaryKey
            val id: Int,
            val name: String,
            val resourceURI: String,
            val thumbnail: String
            //val thumbnail: Thumbnail
        ) {
            data class Thumbnail(
                val extension: String,
                val path: String
            )
        }
    }
}