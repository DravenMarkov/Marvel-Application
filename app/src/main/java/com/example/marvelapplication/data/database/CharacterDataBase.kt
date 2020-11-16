package com.example.marvelapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marvelapplication.data.dao.CharacterDao
import com.example.marvelapplication.domain.entity.CharacterEntity

@Database(
    entities = [CharacterEntity.Data.Result::class],
    version = 1,
    exportSchema = false
)
abstract class CharacterDataBase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object {

        @Volatile
        private var databaseInstance: CharacterDataBase? = null

        fun getDatabaseInstance(context: Context): CharacterDataBase =
            databaseInstance ?: synchronized(this) {
                databaseInstance ?: buildDatabaseInstance(context).also {
                    databaseInstance = it
                }
            }

        fun buildDatabaseInstance(context: Context) =
            Room.databaseBuilder(
                context,
                CharacterDataBase::class.java,
                "characters_db"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}