package com.example.marvelapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marvelapplication.domain.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Insert
    fun insert(character: CharacterEntity.Data.Result)

    @Query("SELECT * FROM characters WHERE id= :character_id")
    fun findCharacterById(character_id: Int): CharacterEntity.Data.Result

    @Query("SELECT EXISTS(SELECT * FROM characters WHERE id = :character_id)")
    fun isExist(character_id: Int): Boolean
}