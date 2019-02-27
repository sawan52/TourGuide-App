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

public class ShoppingMall extends AppCompatActivity {
    // create a variable for ActionBar
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_list);

        //provide and action bar support
        actionBar = getSupportActionBar();

        // then assign the color for this activity action bar
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E91E63")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // created an array list to extract the locationName, locationAddress, locationImage and it's geolocation
        final ArrayList<Name> name = new ArrayList<Name>();
        name.add(new Name("Fun Republic Mall", "Gomti Nagar, Lucknow", R.drawable.fun_republic_mall, "geo:0,0?q=Fun+Republic+Mall,+NH+28,+Vipin+Khand,+Gomti+Nagar,+Lucknow,+Uttar+Pradesh+226016"));
        name.add(new Name("Ada Designer Chikan Studio", "68, Hazratganj, Lucknow", R.drawable.ada_chikan, "geo:0,0?q=Ada+Designer+Chikan+Studio"));
        name.add(new Name("Phoenix United Mall", "NH25, Sector B, Bargawan, LDA Colony, Lucknow", R.drawable.phoenix, "geo:0,0?q=Phoenix+mall"));
        name.add(new Name("Wave Mall", "Vibhuti Khand, Gomti Nagar, Lucknow", R.drawable.wavemalllucknow, "geo:0,0?q=Wave+Mall+Lucknow"));
        name.add(new Name("Bhootnath Market", "Indira Nagar, Lucknow", R.drawable.bhoothnath_market, "geo:0,0?q=Bhoothnath+Market,+Sector+5,+Indira+Nagar,+Lucknow,+Uttar+Pradesh+226016"));
        name.add(new Name("Singapore Mall", "Viraj Khand, Gomti Nagar, Lucknow", R.drawable.singapore_mall, "geo:0,0?q=Singapore+Mall+Pvr+Cinemas"));
        name.add(new Name("Seva Chikan", "6, Park Rd, Raj Bhavan Colony, Hazratganj, Lucknow", R.drawable.seva_chicken, "geo:0,0?q=Seva+Chikan+(Alambagh)"));
        name.add(new Name("Halwasiya Market", "Near Jhandewala Park, Aminabad, Khayali Ganj, Aminabad, Lucknow", R.drawable.halwasiya, "geo:0,0?q=Halwasiya+Market"));

        // create an adapter to get reference of name and also provides it's color(optional)
        final NameAdapter adapter = new NameAdapter(this, name, R.color.shopping_color);

        // provide a reference of list item layout to the list view
        ListView listView = (ListView) findViewById(R.id.list);

        // assign to adapter to set adapter to view
        listView.setAdapter(adapter);

        // create an OnItemClickListener on listView to perform clickable actions
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // getting an item position in shoppingMallName which user selects
                Name shoppingMallName = adapter.getItem(position);

                // parse the url to get the location url
                Uri locationUri = Uri.parse(shoppingMallName.getUrl());

                // provide an intent to open the activity
                Intent intentLocation = new Intent(Intent.ACTION_VIEW, locationUri);

                startActivity(intentLocation);
            }
        });
    }
}
