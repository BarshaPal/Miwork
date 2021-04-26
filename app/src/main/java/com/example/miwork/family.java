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

public class family extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    public static class FamilyFragment extends Fragment {

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
        list.add(new Word("father", "әpә", R.drawable.family_father,R.raw.color_red));
        list.add(new Word("mother", "әṭa",R.drawable.family_mother,R.raw.color_red));
        list.add(new Word("son", "angsi",R.drawable.family_daughter,R.raw.color_red));
        list.add(new Word("daughter", "tune",R.drawable.family_older_brother,R.raw.color_red));
        list.add(new Word("older brother", "taachi",R.drawable.family_grandfather,R.raw.color_red));
        list.add(new Word("younger brother", "chalitti",R.drawable.family_grandmother,R.raw.color_red));
        list.add(new Word("older sister", "teṭe", R.drawable.family_older_sister,R.raw.color_red));
        list.add(new Word("grandmother ", "ama",R.drawable.family_son,R.raw.color_red));
        list.add(new Word("younger sister", "kolliti",R.drawable.family_younger_brother,R.raw.color_red));
        list.add(new Word("grandfather", "paapa",R.drawable.family_younger_sister,R.raw.color_red));
        wordAdapter adapter = new wordAdapter(this, list,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = list.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(family.this, word.getmusic());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}
