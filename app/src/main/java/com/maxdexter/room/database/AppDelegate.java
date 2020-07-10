package com.maxdexter.room.database;

import android.app.Application;

import androidx.room.Room;

// гугл рекомендует создавать базу данных в классе унаследованном от Application, не забываем добавить AppDelegate в манифест
public class AppDelegate extends Application {
    private MusicDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mDatabase = Room.databaseBuilder(this,MusicDatabase.class,"music_database").build();
    }

    public MusicDatabase getDatabase() {
        return mDatabase;
    }
}
