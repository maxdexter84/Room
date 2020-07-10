package com.maxdexter.room;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;

import com.maxdexter.room.database.MusicDao;
import com.maxdexter.room.database.MusicDatabase;

public class MyContentProvider extends ContentProvider {

    private static final String TAG = MyContentProvider.class.getSimpleName();
    private static final String AUTHORITY = "com.maxdexter.room";
    private static final String TABLE_ALBUM = "album";
    public static final int ALBUM_TABLE_CODE = 100;
    private static final int ALBUM_ROW_CODE = 101;

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);


    static {
        URI_MATCHER.addURI(AUTHORITY,TABLE_ALBUM, ALBUM_TABLE_CODE);
        URI_MATCHER.addURI(AUTHORITY,TABLE_ALBUM + "/*", ALBUM_ROW_CODE);
    }

    private MusicDao mMusicDao;

    public MyContentProvider() {
    }

    @Override
    public boolean onCreate() {
        if(getContext() != null){
            mMusicDao = Room.databaseBuilder(getContext().getApplicationContext(), MusicDatabase.class,"music_database")
                    .build().getMusicDao();
        }
        return true;
    }

    @Override
    public String getType(Uri uri) {
       switch (URI_MATCHER.match(uri)){
           case ALBUM_TABLE_CODE:
               return "vnd.cursor.android.dir/" + AUTHORITY+"."+ TABLE_ALBUM;
           case ALBUM_ROW_CODE:
               return "vnd.cursor.android.item/" + AUTHORITY+"."+ TABLE_ALBUM;
           default:
               throw new UnsupportedOperationException("Not yet implemented");
       }

    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable Bundle queryArgs, @Nullable CancellationSignal cancellationSignal) {
        int code = URI_MATCHER.match(uri);
        if(code != ALBUM_ROW_CODE && code != ALBUM_TABLE_CODE ) return null;

        Cursor cursor;
        if(code == ALBUM_TABLE_CODE){
            cursor = mMusicDao.getAlbumsCursor();
        }else {
            cursor = mMusicDao.getAlbumsItIdCursor((int)ContentUris.parseId(uri));
        }
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
