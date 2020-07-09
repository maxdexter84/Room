package com.maxdexter.room.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao//обозначаем интерфейс для работы стаблицами
public interface MusicDao {
//Добавить песни в таблицу
    @Insert
    public void insertSongs(List<Song> songs);

    //Получить все песни из таблици
    @Query("SELECT * from song")
    public List<Song> getSongs();

    //Удалить песню по id
    @Query("DELETE from song where id = :songId")
    void deleteSongById(int songId);

}
