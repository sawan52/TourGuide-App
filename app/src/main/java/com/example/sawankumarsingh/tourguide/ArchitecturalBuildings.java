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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArchitecturalBuildings extends AppCompatActivity {
    // create a variable for ActionBar
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_list);

        //provide and action bar support
        actionBar = getSupportActionBar();

        // then assign the color for this activity action bar
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // created an array list to extract the locationName, locationAddress, locationImage and it's geolocation
        final ArrayList<Name> name = new ArrayList<Name>();
        name.add(new Name("Bara Imambara", "Machchhi Bhavan, Lucknow", R.drawable.bara_imambara, "geo:0,0?q=Bara+Imambara"));
        name.add(new Name("Chhota Imambara", "Husanabad Road, Daulatganj, Lucknow", R.drawable.chhota_imambara, "geo:0,0?q=Chota+Imambara"));
        name.add(new Name("La Martinière College", "La Martinier Road, Martin Purva, Lucknow", R.drawable.constantia, "geo:0,0?q=La+Martinière+College"));
        name.add(new Name("Jahangirabad Palace", "Rani Laxmi Bai Rd, Hazratganj, Lucknow", R.drawable.kaiserbagh_palace, "geo:0,0?q=Jahangirabad+Palace"));
        name.add(new Name("Chattar Manzil", "Mahatma Gandhi Marg, Kaiserbagh, Lucknow", R.drawable.chhatar_manjil, "geo:0,0?q=Chattar+Manzil"));
        name.add(new Name("Sikandar Bagh", "Ashok Marg, Gokhale Vihar, Civil Lines, Lucknow", R.drawable.sikandar_bagh, "geo:0,0?q=Sikandar+Bagh"));
        name.add(new Name("Dilkusha Kothi Palace", "Bibiapur Marg, Neil Lines, Cantonment, Lucknow", R.drawable.dilkusha_kothi_palace, "geo:0,0?q=Dilkusha+Kothi"));

        // create an adapter to get reference of name and also provides it's color(optional)
        final NameAdapter adapter = new NameAdapter(this, name, R.color.architectural_color);

        // provide a reference of list item layout to the list view
        ListView listView = (ListView) findViewById(R.id.list);

        // assign to adapter to set adapter to view
        listView.setAdapter(adapter);

        // create an OnItemClickListener on listView to perform clickable actions
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // getting an item position in architectureName which user selects
                Name architectureName = adapter.getItem(position);

                // parse the url to get the location url
                Uri locationUri = Uri.parse(architectureName.getUrl());

                // provide an intent to open the activity
                Intent intentLocation = new Intent(Intent.ACTION_VIEW, locationUri);
                startActivity(intentLocation);
            }
        });
    }
}
