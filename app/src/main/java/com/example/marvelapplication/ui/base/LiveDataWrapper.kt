package com.example.marvelapplication.ui.base

import com.example.marvelapplication.domain.entity.CharacterEntity

class LiveDataWrapper<T>(
    val responseStatus: RESPONSESTATUS,
    val response: T? = null,
    val error: Throwable? = null
) : List<CharacterEntity.Data.Result> {

    enum class RESPONSESTATUS {
        SUCCESS, LOADING, ERROR
    }

    companion object {
        fun <T> loading() = LiveDataWrapper<T>(RESPONSESTATUS.LOADING)
        fun <T> success(data: T) = LiveDataWrapper<T>(RESPONSESTATUS.SUCCESS, data)
        fun <T> error(err: Throwable) = LiveDataWrapper<T>(RESPONSESTATUS.ERROR, null, err)
    }

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun contains(element: CharacterEntity.Data.Result): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<CharacterEntity.Data.Result>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): CharacterEntity.Data.Result {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: CharacterEntity.Data.Result): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<CharacterEntity.Data.Result> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: CharacterEntity.Data.Result): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<CharacterEntity.Data.Result> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<CharacterEntity.Data.Result> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<CharacterEntity.Data.Result> {
        TODO("Not yet implemented")
    }
}