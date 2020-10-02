package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mColorResourceId;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words          A List of AndroidFlavor objects to display in a list
     */
    public WordAdapter(Activity context,  ArrayList<Word> words,int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId=colorResourceId;
    }
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listitem=convertView;
        if(listitem == null){
            listitem= LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false);

        }
        Word getPos=getItem(position);

        // Find the TextView in the list_item.xml layout with the ID default_name
        // Get the version name from the current getpos object and
        // set this text on the name TextView
        TextView TranlationDefault = (TextView) listitem.findViewById(R.id.default_name);
        TranlationDefault.setText(getPos.getDefaultTranslation());


        // Find the TextView in the list_item.xml layout with the ID trans_name
        // Get the version name from the current getpos object and
        // set this text on the name TextView
        TextView Tranlationminwok = (TextView) listitem.findViewById(R.id.trans_name);
        Tranlationminwok.setText(getPos.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listitem.findViewById(R.id.image);
        // Get the image resource ID from the getImageResourceId object and
        // set the image to iconView
        if(getPos.hasImage()) {
            //set the imageView if the image is present
            imageView.setImageResource(getPos.getImageResourceId());
        }
        else{
            //hide the image view if image isnot present
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listitem.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listitem;
    }
}
