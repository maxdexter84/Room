package com.maxdexter.room.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //если в базе уже есть такой альбом то новый альбом его заменит
    void insertAlbums(List<Album> albums);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSongs(List<Song> songs);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setLinksAlbumSongs(List<AlbumSong> linksAlbumSongs);

    @Query("SELECT * FROM album")
    List<Album> getAlbums();

    @Query("SELECT * FROM song")
    List<Song> getSongs();

    @Delete
    void deleteAlbum(Album album);
    @Query("SELECT * FROM song inner join albumsong on song.id = albumsong.`song id` where `album Id` = :albumId")
    List<Song> getSongsFromAlbums(int albumId);
}
