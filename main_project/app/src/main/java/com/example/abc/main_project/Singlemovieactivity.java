package com.example.abc.main_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;


    public class Singlemovieactivity extends Activity {

        // JSON node keys
        private static final String TAG_ID = "id";
        private static final String TAG_MOVIE_TITLE = "title";
        private static final String TAG_RELEASE_DATE = "release_date";
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_screen);


            Bundle in = getIntent().getExtras();

            // Get JSON values from previous intent
            String name = (String)in.get(TAG_MOVIE_TITLE);
            String date = (String)in.get(TAG_RELEASE_DATE);

            // Displaying all values on the screen
            TextView lblName = (TextView) findViewById(R.id.tv_movie_title);
            TextView lbldate = (TextView) findViewById(R.id.tv_release_date);

            lblName.setText(name);
            lbldate.setText(date);

        }
    }



