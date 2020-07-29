package com.maxdexter.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maxdexter.room.database.Album;
import com.maxdexter.room.database.AppDelegate;
import com.maxdexter.room.database.MusicDao;
import com.maxdexter.room.database.MusicDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd;
    private Button btnGet;
    TextView mTextView;
    List<Album> mAlbums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAlbums = new ArrayList<>();
        MusicDatabase musicDatabase = ((AppDelegate)getApplicationContext()).getDatabase();
        final MusicDao musicDao = musicDatabase.getMusicDao();
        mTextView = findViewById(R.id.textView);
        btnAdd = findViewById(R.id.add);
        btnGet = findViewById(R.id.get);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        musicDao.insertAlbums(createAlbums());
                    }
                }).start();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                      mAlbums = musicDao.getAlbums();
                      mTextView.post(new Runnable() {
                          @Override
                          public void run() {
                              for (Album album: mAlbums){
                                  mTextView.append(album.getName());
                              }

                          }
                      });
                    }
                }).start();
            }
        });

    }

    private List<Album> createAlbums() {
        List<Album> albums = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            albums.add(new Album(i,"album " + i, "releos " + System.currentTimeMillis()));
        }
        return albums;
    }
}