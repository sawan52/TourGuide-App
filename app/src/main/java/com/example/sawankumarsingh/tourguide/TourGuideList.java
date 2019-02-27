package com.example.sawankumarsingh.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TourGuideList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide_list);

        // provide a reference id of architecture to the TextView
        TextView architecture = (TextView) findViewById(R.id.architectural);

        // create an OnClickListener to perform Clickable actions
        architecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create an Intent to open a NewActivity
                Intent architecture = new Intent(TourGuideList.this, ArchitecturalBuildings.class);

                // start that Activity by calling startActivity method
                startActivity(architecture);
            }
        });

        // provide a reference id of museum to the TextView
        TextView museum = (TextView) findViewById(R.id.museum);

        // create an OnClickListener to perform Clickable actions
        museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create an Intent to open a NewActivity
                Intent museum = new Intent(TourGuideList.this, Museums.class);

                // start that Activity by calling startActivity method
                startActivity(museum);
            }
        });

        // provide a reference id of nature to the TextView
        TextView nature = (TextView) findViewById(R.id.nature_parks);

        // create an OnClickListener to perform Clickable actions
        nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create an Intent to open a NewActivity
                Intent nature = new Intent(TourGuideList.this, NatureAndParks.class);

                // start that Activity by calling startActivity method
                startActivity(nature);
            }
        });

        // provide a reference id of shopping to the TextView
        TextView shopping = (TextView) findViewById(R.id.shopping_mall);

        // create an OnClickListener to perform Clickable actions
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create an Intent to open a NewActivity
                Intent shoppping = new Intent(TourGuideList.this, ShoppingMall.class);

                // start that Activity by calling startActivity method
                startActivity(shoppping);
            }
        });

        // provide a reference id of water to the TextView
        TextView water = (TextView) findViewById(R.id.water_parks);

        // create an OnClickListener to perform Clickable actions
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create an Intent to open a NewActivity
                Intent water = new Intent(TourGuideList.this, WaterParks.class);

                // start that Activity by calling startActivity method
                startActivity(water);
            }
        });
    }
}
