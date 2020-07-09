package com.maxdexter.room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity //Обозночаем таблицу
public class Song {
    @PrimaryKey //Первичный ключ, идентификатор статьи
    @ColumnInfo(name = "id") //обозночаем столбец, задаем имя
    private String mId;
    private String mName;
    private String mDuration;
}
