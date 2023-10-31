package com.example.notesapp_big_project.Database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notesapp_big_project.Entities.Notes;

import java.util.List;

@Dao
public interface NoteDAO {
    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, note_text = :notes WHERE ID =:id")
    void update(int id, String title, String notes);

    @Delete
    void delete(Notes notes);
}
