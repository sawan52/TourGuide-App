package com.example.sawankumarsingh.tourguide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NameAdapter extends ArrayAdapter<Name> {
    // create a variable to store resource Id of color
    private int mColorResourceId;

    // create a constructor for NameAdapter class to initialize an Object
    public NameAdapter(Context context, ArrayList<Name> name, int colorResourceId) {
        super(context, 0, name);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //  get each item position in currentName variable
        Name currentName = getItem(position);

        // provide a reference Id for locationName in TextView
        TextView locationName = (TextView) listItemView.findViewById(R.id.location_name);
        // display the provided name based on the Name ID
        locationName.setText(currentName.getLocationName());

        // provide a reference Id for locationAddress in TextView
        TextView locationAddress = (TextView) listItemView.findViewById(R.id.location_address);
        // display the provided address based on the Address ID
        locationAddress.setText(currentName.getLocationAddress());

        // provide a reference Id for locationImage in TextView
        ImageView locationImage = (ImageView) listItemView.findViewById(R.id.location_image);
        if (currentName.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            locationImage.setImageResource(currentName.getLocationImage());
            // Make sure the view is visible
            locationImage.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            locationImage.setVisibility(View.GONE);
        }

        // provide a reference id for textContainer to the View so that it can be displayed on screen
        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
