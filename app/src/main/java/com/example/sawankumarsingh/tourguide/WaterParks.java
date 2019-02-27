package com.example.sawankumarsingh.tourguide;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class WaterParks extends AppCompatActivity {
    // create a variable for ActionBar
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_list);

        //provide and action bar support
        actionBar = getSupportActionBar();

        // then assign the color for this activity action bar
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // created an array list to extract the locationName, locationAddress, locationImage and it's geolocation
        final ArrayList<Name> name = new ArrayList<Name>();
        name.add(new Name("Gautam Buddha Park", "Mahatma Gandhi Marg, Iradat Nagar, Hasanganj, Lucknow", R.drawable.gautam_water_park, "geo:0,0?q=Gautam+Buddha+Park"));
        name.add(new Name("Anandi Water Park", "Canal Road, Beside Indra Canal, Faizabad Road, Lucknow", R.drawable.anandi_water_park, "geo:0,0?q=Anandi+Water+Park"));
        name.add(new Name("Amrapaali Fun Water Park", "Shailamau, Malihabad, Lucknow", R.drawable.amrapali_water_fun_park, "geo:0,0?q=Aamrapaali+Water+Park+Malihabad"));
        name.add(new Name("Dream World Resort", "25th Milestone Lucknow Kanpur Highway", R.drawable.dream_world, "geo:0,0?q=Dream+World+Resort"));
        name.add(new Name("Dream World Amusement Park", "Opposite Nabard, Knapur Road, Sector H, LDA Colony, Lucknow", R.drawable.dream_world_amusement, "geo:0,0?q=Dream+World+Amusement+Park"));
        name.add(new Name("Disney Water Wonder Park", "VS Marg, Narpatkhera, Lalbagh, Lucknow", R.drawable.disney_water_park, "geo:0,0?q=Disney+Water+Wonder+Park"));
        name.add(new Name("Diamond Aqua Park", "Near UPAL, Raibareli Road, Mohanlalganj, Lucknow", R.drawable.diamond_water_park, "geo:0,0?q=Diamond+Aqua+Park"));

        // create an adapter to get reference of name and also provides it's color(optional)
        final NameAdapter adapter = new NameAdapter(this, name, R.color.water_park_color);

        // provide a reference of list item layout to the list view
        ListView listView = (ListView) findViewById(R.id.list);

        // assign to adapter to set adapter to view
        listView.setAdapter(adapter);

        // create an OnItemClickListener on listView to perform clickable actions
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // getting an item position in waterParkName which user selects
                Name waterParkName = adapter.getItem(position);

                // parse the url to get the location url
                Uri locationUri = Uri.parse(waterParkName.getUrl());

                // provide an intent to open the activity
                Intent intentLocation = new Intent(Intent.ACTION_VIEW, locationUri);
                startActivity(intentLocation);
            }
        });
    }
}
