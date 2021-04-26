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

public class phrases extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    public static class PhrasesFragment extends Fragment {

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
        list.add(new Word("Where are you going?", "minto wuksus",R.raw.color_red));
        list.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.color_red));
        list.add(new Word("My name is...", "oyaaset...",R.raw.color_red));
        list.add(new Word("How are you feeling?", "michәksәs?",R.raw.color_red));
        list.add(new Word("I’m feeling good.", "kuchi achit",R.raw.color_red));
        list.add(new Word("Are you coming?", "әәnәs'aa?",R.raw.color_red));
        list.add(new Word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.color_red));
        list.add(new Word("I’m coming.", "әәnәm",R.raw.color_red));
        list.add(new Word("Let’s go.", "yoowutis",R.raw.color_red));
        list.add(new Word("Come here.", "әnni'nem",R.raw.color_red));
        wordAdapter adapter = new wordAdapter(this, list, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = list.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(phrases.this, word.getmusic());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}
