package com.example.marvelapplication.domain.entity

data class CharacterEntity(
    val data: Data
) {
    data class Data(
        val results: List<Result>
    ) {
        data class Result(
            val description: String,
            val id: Int,
            val name: String,
            val resourceURI: String,
            val thumbnail: Thumbnail
        ) {
            /*data class Comics(
                val available: Int,
                val collectionURI: String,
                val items: List<Item>,
                val returned: Int
            ) {
                data class Item(
                    val name: String,
                    val resourceURI: String
                )
            }

            data class Events(
                val available: Int,
                val collectionURI: String,
                val items: List<Item>,
                val returned: Int
            ) {
                data class Item(
                    val name: String,
                    val resourceURI: String
                )
            }

            data class Series(
                val available: Int,
                val collectionURI: String,
                val items: List<Item>,
                val returned: Int
            ) {
                data class Item(
                    val name: String,
                    val resourceURI: String
                )
            }

            data class Stories(
                val available: Int,
                val collectionURI: String,
                val items: List<Item>,
                val returned: Int
            ) {
                data class Item(
                    val name: String,
                    val resourceURI: String,
                    val type: String
                )
            }*/

            data class Thumbnail(
                val extension: String,
                val path: String
            )

            data class Url(
                val type: String,
                val url: String
            )
        }
    }


}