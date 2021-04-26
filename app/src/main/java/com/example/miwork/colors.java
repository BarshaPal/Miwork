package com.example.miwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class colors extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    public static class  ColorsFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.display, container, false);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        ArrayList<Word> list = new ArrayList<Word>();
        list.add(new Word("one","lutti",R.drawable.color_red,R.raw.color_red));
        list.add(new Word("two","lutti",R.drawable.color_black,R.raw.color_red));
        list.add(new Word("three","lutti",R.drawable.color_brown,R.raw.color_red));
        list.add(new Word("four","lutti",R.drawable.color_dusty_yellow,R.raw.color_red));
        list.add(new Word("five","lutti",R.drawable.color_gray,R.raw.color_red));
        list.add(new Word("six","lutti",R.drawable.color_mustard_yellow,R.raw.color_red));
        list.add(new Word("seven","lutti",R.drawable.color_white,R.raw.color_red));
        wordAdapter adapter = new wordAdapter(this, list, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = list.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(colors.this, word.getmusic());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}
