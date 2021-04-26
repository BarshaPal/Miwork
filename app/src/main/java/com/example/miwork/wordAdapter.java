package com.example.miwork;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<Word> {
    private int mcolor;
    private int music;

 private Button b1;
    public wordAdapter(Activity context, ArrayList<Word> list, int colorid) {
        super(context, 0, list);
        mcolor=colorid;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentword = getItem(position);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miw_text);
        nameTextView.setText(currentword.getmMiWTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_text);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentword.getmDefaultTranslation());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        if(currentword.hasimage()) {
            image.setImageResource(currentword.getImage());
        }
        else
        {
            image.setVisibility(View.GONE);
        }
        int color= ContextCompat.getColor(getContext(),mcolor);
        listItemView.setBackgroundColor(color);

        return listItemView;

    }
}