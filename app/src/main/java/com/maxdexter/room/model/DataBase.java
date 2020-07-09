package com.maxdexter.room.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Song.class},version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract MusicDao getMusicDao();
}
