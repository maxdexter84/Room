package com.maxdexter.room.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
//эта анотация связывает между собой по id две таблицы , Album и Song
@Entity(foreignKeys = {@ForeignKey(entity = Album.class,parentColumns = "id", childColumns = "album_id"),
                        @ForeignKey(entity = Song.class,parentColumns = "id",childColumns = "song_id")})
public class AlbumSong {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mId;
    @ColumnInfo(name = "album_id")
    private int mAlbumId;
    @ColumnInfo(name = "song_id")
    private int mSongId;

    public AlbumSong(int id, int albumId, int songId) {
        mId = id;
        mAlbumId = albumId;
        mSongId = songId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getAlbumId() {
        return mAlbumId;
    }

    public void setAlbumId(int albumId) {
        mAlbumId = albumId;
    }

    public int getSongId() {
        return mSongId;
    }

    public void setSongId(int songId) {
        mSongId = songId;
    }

    public AlbumSong() {
    }
}
