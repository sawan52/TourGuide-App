package com.example.sawankumarsingh.tourguide;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NatureAndParks extends AppCompatActivity {
    // create a variable for ActionBar
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_list);

        //provide and action bar support
        actionBar = getSupportActionBar();

        // then assign the color for this activity action bar
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F44336")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // created an array list to extract the locationName, locationAddress, locationImage and it's geolocation
        final ArrayList<Name> name = new ArrayList<Name>();
        name.add(new Name("Janeshwar Mishra Park", "Gomti Nagar, Lucknow", R.drawable.janeshwar_mishra, "geo:0,0?q=Janeshwar+Mishra+Park"));
        name.add(new Name("Nawab Wajid Ali Shah Zoological Garden", "Narhi, Hazratganj, Lucknow", R.drawable.nawab_wajid, "geo:0,0?q=Nawab+Wajid+Ali+Shah+Zoological+Garden"));
        name.add(new Name("Dr. Ambedkar Park", "Vipul Khand 2, Vipul Khand 3, Gomti Nagar, Lucknow", R.drawable.ambedakar_park, "geo:0,0?q=Ambedkar+Park"));
        name.add(new Name("Kukrail Gharial Park", "Faridi Nagar, Indira Nagar, Lucknow", R.drawable.kukrail_forest, "geo:0,0?q=Kukrail+Gharial+Park"));
        name.add(new Name("Begum Hazrat Mahal Park", "Rani Lakshmi Bai Marg, Kaiserbagh, Lucknow", R.drawable.begum_hazrat, "geo:0,0?q=Begum+Hazarat+Mahal+Park,+Qaiserbagh,+Lucknow,+Uttar+Pradesh+226001"));
        name.add(new Name("Dr. Ram Manohar Lohia Park", "Vipin Khand, Gomti Nagar, Lucknow", R.drawable.ram_manohar_lohia_park, "geo:0,0?q=Dr.+Ram+Manohar+Lohia+Park"));
        name.add(new Name("Botanical Gardens", "Railway Colony, Charbagh, Lucknow", R.drawable.botanical_garden, "geo:0,0?q=Botanical+Garden"));
        name.add(new Name("Gomti RiverFront Park", "Jiamau, Lucknow", R.drawable.gomti_river_front, "geo:0,0?q=Gomti+Riverfront+Park"));
        name.add(new Name("Ganga Aquarium", "Telibagh, Lucknow", R.drawable.ganga_aquarium, "geo:0,0?q=Ganga+Aquarium"));

        // create an adapter to get reference of name and also provides it's color(optional)
        final NameAdapter adapter = new NameAdapter(this, name, R.color.nature_park_color);

        // provide a reference of list item layout to the list view
        ListView listView = (ListView) findViewById(R.id.list);

        // assign to adapter to set adapter to view
        listView.setAdapter(adapter);

        // create an OnItemClickListener on listView to perform clickable actions
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // getting an item position in parkName which user selects
                Name parkName = adapter.getItem(position);

                // parse the url to get the location url
                Uri locationUri = Uri.parse(parkName.getUrl());

                // provide an intent to open the activity
                Intent intentLocation = new Intent(Intent.ACTION_VIEW, locationUri);
                startActivity(intentLocation);
            }
        });
    }
}
