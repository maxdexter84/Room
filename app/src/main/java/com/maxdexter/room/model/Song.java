package com.maxdexter.room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity //Обозночаем таблицу
public class Song {
    @PrimaryKey //Первичный ключ, идентификатор статьи
    @ColumnInfo(name = "id") //обозночаем столбец, задаем имя
    private String mId;
    @ColumnInfo(name = "name")
    private String mName;
    @ColumnInfo(name = "duration")
    private String mDuration;

    
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }


}
