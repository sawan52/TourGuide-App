package com.example.sawankumarsingh.tourguide;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // create a static variable constant TIME_OUT to store the max. value for screen appearance.
    private static int TIME_OUT = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //create an Intent to open a NewActivity
                Intent nextIntent = new Intent(MainActivity.this, TourGuideList.class);

                // start that Activity by calling startActivity method
                startActivity(nextIntent);

                // destroy this activity after loading...
                finish();
            }
        }, TIME_OUT);
    }
}
