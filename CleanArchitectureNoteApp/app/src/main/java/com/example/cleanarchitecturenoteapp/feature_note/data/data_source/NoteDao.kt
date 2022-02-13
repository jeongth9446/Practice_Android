package com.example.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.*
import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao //Dao?
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNode(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}