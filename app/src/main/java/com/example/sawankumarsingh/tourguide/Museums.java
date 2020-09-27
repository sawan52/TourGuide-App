package com.example.sawankumarsingh.tourguide;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Museums extends AppCompatActivity {
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_list);

        //provide and action bar support
        actionBar = getSupportActionBar();

        // then assign the color for this activity action bar
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03A9F4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // created an array list to extract the locationName, locationAddress, locationImage and it's geolocation
        final ArrayList<Name> name = new ArrayList<Name>();
        name.add(new Name("Jai Prakash Narayan Museum", "Vipin Khand, Gomti Nagar, Lucknow", R.drawable.jaypraksh_narayan, "geo:0,0?q=Jai+Prakash+Narayan+Museum"));
        name.add(new Name("Bal Sangrahalaya", "539, Station Rd, Udaiganj, Husainganj, Lucknow", R.drawable.bal_sangrahalaya, "geo:0,0?q=BAL+SANGRAHALAY"));
        name.add(new Name("State Museum", "Narhi, Hazratganj, Lucknow", R.drawable.state_museum, "geo:0,0?q=State+Museum+Lucknow"));
        name.add(new Name("Hussainabad Picture Gallery", "Husainabad, Lucknow", R.drawable.hussainabad_picture_gallery, "geo:0,0?q=Picture+Gallery"));
        name.add(new Name("Indira gandhi Planetarium", "Vigyan Bhawan, 9 Nabiullah Roaad, Surajkund Park, Lucknow", R.drawable.indira_gandhi_platenerium, "geo:0,0?q=Indira+Gandhi+Planetarium,+Nabiullah+Rd,+Qaiserbagh,+Lucknow,+Uttar+Pradesh+226018"));
        name.add(new Name("1857 Memorial Museum", "River Bank Colony, Kaiserbagh, Lucknow", R.drawable.residency_1857_lucknow, "geo:0,0?q=1857-Memorial+Museum+Residency"));
        name.add(new Name("British Residency", "Mahatma Gandhi Marg, Deep Manak Nagar, Kaiserbagh, Lucknow", R.drawable.british_residency, "geo:0,0?q=The+Residency"));

        // create an adapter to get reference of name and also provides it's color(optional)
        final NameAdapter adapter = new NameAdapter(this, name, R.color.museum_color);

        // provide a reference of list item layout to the list view
        ListView listView = (ListView) findViewById(R.id.list);

        // assign to adapter to set adapter to view
        listView.setAdapter(adapter);

        // create an OnItemClickListener on listView to perform clickable actions
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // getting an item position in museumName which user selects
                Name museumName = adapter.getItem(position);

                // parse the url to get the location url
                Uri locationUri = Uri.parse(museumName.getUrl());

                // provide an intent to open the activity
                Intent intentLocation = new Intent(Intent.ACTION_VIEW, locationUri);

                startActivity(intentLocation);
            }
        });
    }
}
